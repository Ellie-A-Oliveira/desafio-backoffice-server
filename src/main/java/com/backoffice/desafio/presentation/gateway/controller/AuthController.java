package com.backoffice.desafio.presentation.gateway.controller;

import com.backoffice.desafio.config.JwtConfig;
import com.backoffice.desafio.infrastructure.jwt.JwtTokenUtil;
import com.backoffice.desafio.presentation.gateway.dto.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private JwtTokenUtil jwtTokenUtil;
    private JwtConfig jwtConfig;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateToken(authRequest.username());
        return ResponseEntity.ok(jwtConfig.getTokenPrefix() + jwt);
    }
}
