package com.backoffice.desafio.presentation.gateway.controller;

import com.backoffice.desafio.application.usecase.staffmember.*;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.exception.StaffMemberNotFoundException;
import com.backoffice.desafio.infrastructure.mapper.StaffMemberMapper;
import com.backoffice.desafio.presentation.gateway.dto.request.CreateStaffMemberRequest;
import com.backoffice.desafio.presentation.gateway.dto.request.UpdateStaffMemberRequest;
import com.backoffice.desafio.presentation.gateway.dto.response.GetStaffMemberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/staff-member")
@RequiredArgsConstructor
public class StaffMemberController {
    private final StaffMemberMapper staffMemberMapper;

    // Use cases
    private final GetAllStaffMember getAllStaffMember;
    private final GetStaffMemberById getStaffMemberById;
    private final CreateStaffMember createStaffMember;
    private final UpdateStaffMember updateStaffMember;
    private final DeleteStaffMember deleteStaffMember;

    @GetMapping
    public ResponseEntity<List<GetStaffMemberResponse>> getAll() {
        List<GetStaffMemberResponse> response = staffMemberMapper.staffMembersToGetStaffMemberResponses(getAllStaffMember.execute());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStaffMemberResponse> getById(
            @PathVariable UUID id) {
        Optional<StaffMember> foundStaffMember = getStaffMemberById.execute(id);

        if (foundStaffMember.isEmpty()) return ResponseEntity.notFound().build();

        GetStaffMemberResponse response = staffMemberMapper.staffMemberToGetStaffMemberResponse(foundStaffMember.get());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UUID> create(
            @RequestBody @Valid CreateStaffMemberRequest staffMemberRequest) {
        StaffMember staffMemberToBeCreated = staffMemberMapper.createStaffMemberRequestToStaffMember(staffMemberRequest);
        StaffMember createdStaffMember = createStaffMember.execute(staffMemberToBeCreated);
        return ResponseEntity.status(201).body(createdStaffMember.getStaffId());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UUID> update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateStaffMemberRequest staffMemberRequest)
            throws BadRequestException {
        StaffMember staffMemberToBeUpdated = staffMemberMapper.updateStaffMemberRequestToStaffMember(staffMemberRequest);

        try {
            updateStaffMember.execute(id, staffMemberToBeUpdated);
        } catch (StaffMemberNotFoundException e) {
            throw new BadRequestException(e);
        }

        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {
        try {
            deleteStaffMember.execute(id);
        } catch (StaffMemberNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
