package com.medufly.edu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "leads")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phone;

    private String email;
    private String city;
    private String state;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(name = "preferred_country")
    private String preferredCountry;

    @Column(nullable = false)
    private String source;   // apply | contact | counseling

    @Column(nullable = false)
    private String status;   // new | contacted | enrolled | not_interested

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "admin_notes", columnDefinition = "TEXT")
    private String adminNotes;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;

    @PrePersist
    void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (status == null) status = "new";
    }
}
