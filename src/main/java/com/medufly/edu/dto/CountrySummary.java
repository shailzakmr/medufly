package com.medufly.edu.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO representing a country summary with university count.
 */
@Getter
@Setter
public class CountrySummary {

    private int countryId;
    private String countryCode;
    private String countryName;
    private int universityCount;

    public CountrySummary(int countryId, String countryCode, String countryName, int universityCount) {
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.universityCount = universityCount;
    }

}



