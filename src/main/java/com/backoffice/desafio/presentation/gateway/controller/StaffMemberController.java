package com.backoffice.desafio.presentation.gateway.controller;

import com.backoffice.desafio.application.usecase.CreateStaffMember;
import com.backoffice.desafio.application.usecase.GetAllStaffMember;
import com.backoffice.desafio.application.usecase.GetStaffMemberById;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.infrastructure.mapper.StaffMemberMapper;
import com.backoffice.desafio.presentation.gateway.dto.request.CreateStaffMemberRequest;
import com.backoffice.desafio.presentation.gateway.dto.response.GetStaffMemberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController("/api/v1/staff-member")
@Component
@RequiredArgsConstructor
public class StaffMemberController {
    private final StaffMemberMapper staffMemberMapper;

    // Use cases
    private final CreateStaffMember createStaffMember;
    private final GetAllStaffMember getAllStaffMember;
    private final GetStaffMemberById getStaffMemberById;

    @GetMapping
    public ResponseEntity<List<GetStaffMemberResponse>> getAll() {
        List<GetStaffMemberResponse> response = staffMemberMapper.staffMembersToGetStaffMemberResponses(getAllStaffMember.execute());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStaffMemberResponse> getById(@PathVariable UUID id) {
        Optional<StaffMember> foundStaffMember = getStaffMemberById.execute(id);
        GetStaffMemberResponse response = staffMemberMapper.staffMemberToGetStaffMemberResponse(foundStaffMember.orElse(null));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody @Valid CreateStaffMemberRequest staffMemberRequest) {
        StaffMember staffMemberToBeCreated = staffMemberMapper.createStaffMemberRequestToStaffMember(staffMemberRequest);
        StaffMember createdStaffMember = createStaffMember.execute(staffMemberToBeCreated);
        return ResponseEntity.status(201).body(createdStaffMember.getStaffId());
    }
}
