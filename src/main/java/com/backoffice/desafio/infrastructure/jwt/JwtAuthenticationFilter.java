package com.backoffice.desafio.infrastructure.jwt;

import com.backoffice.desafio.application.usecase.staffmember.GetStaffMemberByEmail;
import com.backoffice.desafio.config.JwtConfig;
import com.backoffice.desafio.domain.entity.StaffMember;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtConfig jwtConfig;
    private final GetStaffMemberByEmail getStaffMemberByEmail;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().startsWith("/auth/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getTokenFromRequest(request);
        if (token != null && jwtTokenUtil.validateToken(token)) {
            String username = jwtTokenUtil.getUsernameFromToken(token);
            StaffMember user = getStaffMemberByEmail.execute(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user, null, getGrantedAuthoritiesFromUser(user)
            );

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        String tokenPrefix = jwtConfig.getTokenPrefix();

        if (header != null && header.startsWith(tokenPrefix)) {
            return header.substring(tokenPrefix.length());
        }

        return null;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthoritiesFromUser(StaffMember user) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }
}
