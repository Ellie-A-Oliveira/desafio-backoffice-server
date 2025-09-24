package com.backoffice.desafio.application.usecase.staffmember;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface LoadUserByUsername extends UserDetailsService {
}
