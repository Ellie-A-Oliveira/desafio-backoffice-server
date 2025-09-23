package com.backoffice.desafio.infrastructure.data.repository;

import com.backoffice.desafio.domain.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InquiryRepository extends JpaRepository<Inquiry, UUID> {
}
