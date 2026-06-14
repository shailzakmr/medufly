package com.medufly.edu.service;

import com.medufly.edu.dao.EducationDao;
import com.medufly.edu.dto.CountrySummary;
import com.medufly.edu.dto.HomeSummary;
import com.medufly.edu.dto.UniversityDto;
import com.medufly.edu.dto.UniversitiesAndFeesResponseDto;
import com.medufly.edu.dto.CountryDetailsDto;
import com.medufly.edu.dto.FeeDto;
import com.medufly.edu.dto.ServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationService {

    private final EducationDao educationDao;

    @Autowired
    public EducationService(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    public List<CountrySummary> getCountriesSummary() {
        List<CountrySummary> summaries = educationDao.findCountrySummaries();
        return summaries != null ? summaries : new ArrayList<>();
    }

    /**
     * Assemble HomeSummary containing countries summary and services list.
     */
    public HomeSummary getHomeSummary() {
        HomeSummary summary = new HomeSummary();
        summary.setCountries(getCountriesSummary());
        List<ServiceDto> services = educationDao.findAllServices();
        summary.setServices(services != null ? services : new ArrayList<>());
        return summary;
    }

    public UniversitiesAndFeesResponseDto getUniversitiesAndFeesSeparately(Integer countryId) {
        UniversitiesAndFeesResponseDto response = new UniversitiesAndFeesResponseDto();
        if (countryId == null) {
            response.setCountry(null);
            response.setUniversities(new ArrayList<>());
            response.setFees(new ArrayList<>());
            return response;
        }

        CountryDetailsDto country = educationDao.findCountryDetails(countryId);
        List<UniversityDto> universities = educationDao.findUniversitiesByCountry(countryId);
        List<FeeDto> fees = educationDao.findFeesByCountry(countryId);

        response.setCountry(country);
        response.setUniversities(universities != null ? universities : new ArrayList<>());
        response.setFees(fees != null ? fees : new ArrayList<>());
        return response;
    }
}


