package com.backoffice.desafio.domain.entity;

import com.backoffice.desafio.domain.enumerator.InquiryPriority;
import com.backoffice.desafio.domain.enumerator.InquiryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID caseId;

    private String caseNumber;
    private String title;
    private Instant openedAt;
    private Instant closedAt;
    private String resolutionNotes;

    @Enumerated(EnumType.STRING)
    private InquiryPriority priority;

    @Enumerated(EnumType.STRING)
    private InquiryStatus status;

    @OneToMany
    private List<Transaction> transactions;

    @OneToMany
    private List<StaffActionLog> staffActionLogs;

    @ManyToOne
    private StaffMember staffMember;
}
