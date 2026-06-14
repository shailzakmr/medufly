package com.medufly.edu.dao;

import com.medufly.edu.dto.CountrySummary;
import com.medufly.edu.dto.ServiceDto;
import com.medufly.edu.dto.UniversityDto;
import com.medufly.edu.dto.FeeDto;
import com.medufly.edu.dto.CountryDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EducationDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired(required = false)
    public EducationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CountrySummary> findCountrySummaries() {
        List<CountrySummary> result = new ArrayList<>();
        if (jdbcTemplate == null) return result;
        try {
            String sql = "SELECT c.country_id, c.code AS country_code, c.name AS country_name, "
                    + "COUNT(u.university_id) AS university_count "
                    + "FROM countries c LEFT JOIN universities u ON u.country_id = c.country_id "
                    + "GROUP BY c.country_id, c.code, c.name ORDER BY c.country_id";

            return jdbcTemplate.query(sql, (rs, rowNum) -> new CountrySummary(
                    rs.getInt("country_id"),
                    rs.getString("country_code"),
                    rs.getString("country_name"),
                    rs.getInt("university_count")
            ));
        } catch (DataAccessException ex) {
            return result;
        }
    }

    public List<ServiceDto> findAllServices() {
        List<com.medufly.edu.dto.ServiceDto> result = new ArrayList<>();
        if (jdbcTemplate == null) return result;
        try {
            String sql = "SELECT service_id, name, content FROM services ORDER BY service_id";
            return jdbcTemplate.query(sql, (rs, rowNum) -> new com.medufly.edu.dto.ServiceDto(
                    rs.getInt("service_id"),
                    rs.getString("name"),
                    rs.getString("content")
            ));
        } catch (DataAccessException ex) {
            return result;
        }
    }

    public List<UniversityDto> findUniversitiesByCountry(int countryId) {
        List<UniversityDto> result = new ArrayList<>();
        if (jdbcTemplate == null) return result;
        try {
            String sql = "SELECT university_id, name, location, image_url, description, country_id "
                    + "FROM universities WHERE country_id = ? ORDER BY university_id";

            return jdbcTemplate.query(sql, new Object[]{countryId}, (rs, rowNum) -> new UniversityDto(
                    rs.getInt("university_id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("image_url"),
                    rs.getString("description"),
                    rs.getInt("country_id")
            ));
        } catch (DataAccessException ex) {
            return result;
        }
    }

    public List<FeeDto> findFeesByCountry(int countryId) {
        List<FeeDto> result = new ArrayList<>();
        if (jdbcTemplate == null) return result;
        try {
            // First, get the country code for this country_id
            String countryCodeSql = "SELECT code FROM countries WHERE country_id = ?";
            String countryCode = jdbcTemplate.queryForObject(countryCodeSql, new Object[]{countryId}, String.class);

            if (countryCode == null) return result;

            // Then, get fees for this country_code
            String sql = "SELECT fee_id, year_number, tuition, hostel, total "
                    + "FROM fees WHERE country_code = ? "
                    + "ORDER BY year_number";

            return jdbcTemplate.query(sql, new Object[]{countryCode}, (rs, rowNum) -> new FeeDto(
                    rs.getInt("fee_id"),
                    countryCode,
                    rs.getInt("year_number"),
                    rs.getInt("tuition"),
                    rs.getInt("hostel"),
                    rs.getInt("total")
            ));
        } catch (DataAccessException ex) {
            return result;
        }
    }

    public CountryDetailsDto findCountryDetails(int countryId) {
        if (jdbcTemplate == null) return null;
        try {
            String sql = "SELECT country_id, name, code, total_fees, duration, language, "
                    + "nmc_approved, neet_required, intake FROM countries WHERE country_id = ?";

            return jdbcTemplate.queryForObject(sql, new Object[]{countryId}, (rs, rowNum) -> 
                new CountryDetailsDto(
                    rs.getInt("country_id"),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getInt("total_fees"),
                    rs.getInt("duration"),
                    rs.getString("language"),
                    rs.getInt("nmc_approved"),
                    rs.getInt("neet_required"),
                    rs.getString("intake")
                )
            );
        } catch (DataAccessException ex) {
            return null;
        }
    }

}



