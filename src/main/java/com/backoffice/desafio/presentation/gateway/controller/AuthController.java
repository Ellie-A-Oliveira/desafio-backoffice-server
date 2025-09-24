package com.backoffice.desafio.presentation.gateway.controller;

import com.backoffice.desafio.application.usecase.staffmember.CreateStaffMember;
import com.backoffice.desafio.config.JwtConfiguration;
import com.backoffice.desafio.domain.entity.StaffMember;
import com.backoffice.desafio.domain.enumerator.StaffRole;
import com.backoffice.desafio.infrastructure.jwt.JwtTokenUtil;
import com.backoffice.desafio.presentation.gateway.dto.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CreateStaffMember createStaffMember;
    private JwtTokenUtil jwtTokenUtil;
    private JwtConfiguration jwtConfiguration;

    @PostMapping("/register")
    public ResponseEntity<String> registerStub() throws Exception {
        StaffMember sm = StaffMember.builder()
                .email("ellie")
                .passwordHash("123")
                .role(StaffRole.AUDITOR)
                .fullName("Ellie")
                .build();
        createStaffMember.execute(sm);
        return ResponseEntity.ok("Created stub.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody AuthRequest authRequest) {
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        if (!(currentAuth instanceof AnonymousAuthenticationToken)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Already authenticated");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateToken(authRequest.username());
        System.out.println(jwt);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, jwtConfiguration.getTokenPrefix() + jwt)
                .body("Login successful.");
    }
}
