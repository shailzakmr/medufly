package com.medufly.edu.entity;

import com.medufly.edu.config.JsonConverter;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;
    private String typeColor;
    private LocalDate eventDate;
    private String eventTime;
    private String venue;
    private Integer seats;
    private Integer seatsLeft;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private Object highlights;

    @Builder.Default
    private Boolean isPast = false;

    private Integer attendees;
    private String outcome;

    @Builder.Default
    private Boolean active = true;
}
