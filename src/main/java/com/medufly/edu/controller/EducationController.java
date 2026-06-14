package com.medufly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// removed unused RequestParam import
import org.springframework.web.bind.annotation.RestController;

import com.medufly.edu.dto.HomeSummary;
import com.medufly.edu.dto.UniversitiesAndFeesResponseDto;
import com.medufly.edu.service.EducationService;

@RestController
@RequestMapping("/api")
public class EducationController {

	// No limit-per-country configuration; return full lists per country

	private final EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		this.educationService = educationService;
	}

	/**
	 * Return list of countries with university counts.
	 * If a DataSource/JdbcTemplate is available this will run a grouped SQL query.
	 * Otherwise falls back to configured country ids with a count of 0.
	 */
	@GetMapping("/home/countries-summary")
	public HomeSummary getCountriesSummary() {
		return educationService.getHomeSummary();
	}

	/**
	 * Return list of universities and fee structure for a given country id.
	 * Universities and fees are returned as separate lists.
	 * Path: /api/countries/{countryId}/universities
	 */
	@GetMapping("/countries/{countryId}/universities")
	public UniversitiesAndFeesResponseDto getUniversitiesByCountry(@PathVariable Integer countryId) {
		return educationService.getUniversitiesAndFeesSeparately(countryId);
	}

}












