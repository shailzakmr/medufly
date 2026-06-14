package com.medufly.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO containing detailed country information.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDetailsDto {
    private int countryId;
    private String name;
    private String code;
    private int totalFees;
    private int duration;
    private String language;
    private int nmcApproved;
    private int neetRequired;
    private String intake;
}

