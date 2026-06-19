package com.medufly.edu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "testimonials")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Testimonial {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String initials;
    private String color;
    private String country;
    private String university;
    @Column(name = "grad_year")
    private String year;
    private Integer rating;

    private String photoUrl;

    @Column(columnDefinition = "TEXT")
    private String quote;

    @Builder.Default
    private Boolean active = true;
}
