package com.backoffice.desafio.infrastructure.jwt;

import com.backoffice.desafio.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    private final JwtConfig jwtConfig;

    public String generateToken(String username) {
        return Jwts.builder()
                .claim("sub", username)
                .claim("iat", Instant.now())
                .claim("exp", Instant.now().plusMillis(jwtConfig.getExpirationTime()))
                .signWith(getSecretKey())
                .compact();
    }

    public boolean validateToken(String token) {
        if (token == null) return false;

        Claims claims = Jwts.parser()
                .decryptWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        boolean isSubValid = claims.getSubject() != null;
        boolean isExpValid = claims.getExpiration().after(new Date());

        return isSubValid && isExpValid;
    }

    public String getUsernameFromToken(String token) {
        if (token == null) return null;

        Claims claims = Jwts.parser()
                .decryptWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
    }
}
