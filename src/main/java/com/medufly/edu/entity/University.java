package com.medufly.edu.entity;

import com.medufly.edu.config.JsonConverter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "universities_v2")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class University {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;
    private String name;
    private String countrySlug;
    private String countryName;
    private String flag;
    private String city;
    private Integer founded;
    private Boolean nmc;
    private String duration;
    private String medium;
    private String annualFee;
    private String hostelFee;
    private String totalFee;
    private String intake;
    private String badge;

    @Column(columnDefinition = "TEXT")
    private String overview;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object highlights;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object courses;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object facilities;
}
