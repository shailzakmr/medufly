package com.medufly.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/**
 * Response DTO containing country details, universities, and fee structure.
 * Universities and fees are returned as separate lists along with country information.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversitiesAndFeesResponseDto {
    private CountryDetailsDto country;
    private List<UniversityDto> universities;
    private List<FeeDto> fees;
}

