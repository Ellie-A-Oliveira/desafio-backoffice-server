package com.backoffice.desafio.domain.entity;

import com.backoffice.desafio.domain.enumerator.StaffRole;
import com.backoffice.desafio.domain.enumerator.StaffStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID staffId;

    private String fullName;
    private String email;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    @Enumerated(EnumType.STRING)
    private StaffStatus status;

    @OneToMany
    private List<StaffActionLog> staffActionLogs;

    @OneToMany
    private List<Inquiry> inquiries;

    @OneToMany
    private List<TransactionFlag> transactionFlags;
}
