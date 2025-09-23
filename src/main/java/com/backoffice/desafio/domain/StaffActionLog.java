package com.backoffice.desafio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
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
    private Case relatedCase;
}
