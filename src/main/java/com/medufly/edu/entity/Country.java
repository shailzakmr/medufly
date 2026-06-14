package com.medufly.edu.entity;

import com.medufly.edu.config.JsonConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countries_v2")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;
    private String name;
    private String flag;
    private String tagline;

    @Column(columnDefinition = "TEXT")
    private String overview;

    private String totalFees;
    private String duration;
    private String language;
    private Boolean nmcApproved;
    private Boolean neetRequired;
    private String intake;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object highlights;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object fees;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object eligibility;

    @Convert(converter = JsonConverter.class)
    @Column(name = "why_study", columnDefinition = "TEXT")
    private Object whyStudy;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object faqs;
}
