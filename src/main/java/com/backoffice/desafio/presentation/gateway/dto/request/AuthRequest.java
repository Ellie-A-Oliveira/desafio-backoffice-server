package com.backoffice.desafio.presentation.gateway.dto.request;

public record AuthRequest(
        String username,
        String password
) { }
