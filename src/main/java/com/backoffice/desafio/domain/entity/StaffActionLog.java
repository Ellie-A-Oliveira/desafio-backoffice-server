package com.backoffice.desafio.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffActionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID actionId;

    private Instant performedAt;
    private String comment;

    @ManyToOne
    private StaffMember performedBy;

    @ManyToOne
    private Inquiry relatedInquiry;
}
