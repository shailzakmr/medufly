package com.medufly.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeDto {
    private int feeId;
    private String countryCode;
    private int yearNumber;
    private int tuition;
    private int hostel;
    private int total;
}


