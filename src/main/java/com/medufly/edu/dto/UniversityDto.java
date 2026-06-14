package com.medufly.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto {
    private int universityId;
    private String name;
    private String location;
    private String imageUrl;
    private String description;
    private int countryId;
}

