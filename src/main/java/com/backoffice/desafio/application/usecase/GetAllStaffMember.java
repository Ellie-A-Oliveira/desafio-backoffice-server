package com.backoffice.desafio.application.usecase;

import com.backoffice.desafio.domain.entity.StaffMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllStaffMember {
    List<StaffMember> execute();
}
