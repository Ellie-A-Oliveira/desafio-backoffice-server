package com.backoffice.desafio.domain.entity;

import com.backoffice.desafio.domain.enumerator.StaffRole;
import com.backoffice.desafio.domain.enumerator.StaffStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Builder
public class StaffMember {
    private UUID staffId;

    private String fullName;
    private String email;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    @Enumerated(EnumType.STRING)
    private StaffStatus status;

    @OneToMany
    private List<StaffActionLog> staffActionLogs;

    @OneToMany
    private List<Case> cases;

    @OneToMany
    private List<TransactionFlag> transactionFlags;
}
