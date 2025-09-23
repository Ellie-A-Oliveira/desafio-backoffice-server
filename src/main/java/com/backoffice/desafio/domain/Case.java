package com.backoffice.desafio.domain;

import com.backoffice.desafio.domain.enumeration.CasePriority;
import com.backoffice.desafio.domain.enumeration.CaseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID caseId;

    private String caseNumber;
    private String title;
    private Instant openedAt;
    private Instant closedAt;
    private String resolutionNotes;

    @Enumerated(EnumType.STRING)
    private CasePriority priority;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    @OneToMany
    private List<Transaction> transactions;

    @OneToMany
    private List<StaffActionLog> staffActionLogs;

    @ManyToOne
    private StaffMember staffMember;
}
