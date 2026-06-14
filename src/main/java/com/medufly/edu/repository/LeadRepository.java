package com.medufly.edu.repository;

import com.medufly.edu.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
