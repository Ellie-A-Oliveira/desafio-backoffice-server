package com.backoffice.desafio.application.usecase.staffmember.impl;

import com.backoffice.desafio.application.usecase.staffmember.GetStaffMemberByEmail;
import com.backoffice.desafio.application.usecase.staffmember.LoadUserByUsername;
import com.backoffice.desafio.domain.entity.StaffMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadUserByUsernameImpl implements LoadUserByUsername, UserDetailsService {
    private final GetStaffMemberByEmail getStaffMemberByEmail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StaffMember user = getStaffMemberByEmail.execute(username);
        System.out.println(user);
        if (user == null) throw new UsernameNotFoundException("Incorrect credentials.");
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
            }

            @Override
            public String getPassword() {
                return user.getPasswordHash();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }
        };
    }
}
