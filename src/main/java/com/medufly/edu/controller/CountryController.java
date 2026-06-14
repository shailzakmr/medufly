package com.medufly.edu.controller;

import com.medufly.edu.entity.Country;
import com.medufly.edu.entity.University;
import com.medufly.edu.repository.CountryRepository;
import com.medufly.edu.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryRepository countryRepository;
    private final UniversityRepository universityRepository;

    public CountryController(CountryRepository countryRepository,
                             UniversityRepository universityRepository) {
        this.countryRepository = countryRepository;
        this.universityRepository = universityRepository;
    }

    @GetMapping
    public List<Map<String, Object>> listCountries() {
        return countryRepository.findAll().stream()
            .map(c -> {
                int uniCount = universityRepository.findByCountrySlug(c.getSlug()).size();
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("slug", c.getSlug());
                map.put("name", c.getName());
                map.put("flag", c.getFlag());
                map.put("universityCount", uniCount);
                return map;
            })
            .toList();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Map<String, Object>> getCountry(@PathVariable String slug) {
        Optional<Country> opt = countryRepository.findBySlug(slug);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        Country c = opt.get();
        List<University> unis = universityRepository.findByCountrySlug(slug);

        List<Map<String, Object>> uniList = unis.stream()
            .map(u -> {
                Map<String, Object> um = new LinkedHashMap<>();
                um.put("slug", u.getSlug());
                um.put("name", u.getName());
                um.put("city", u.getCity());
                um.put("founded", u.getFounded());
                um.put("nmc", u.getNmc());
                um.put("badge", u.getBadge());
                return um;
            })
            .toList();

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id", c.getId());
        result.put("slug", c.getSlug());
        result.put("name", c.getName());
        result.put("flag", c.getFlag());
        result.put("tagline", c.getTagline());
        result.put("overview", c.getOverview());
        result.put("totalFees", c.getTotalFees());
        result.put("duration", c.getDuration());
        result.put("language", c.getLanguage());
        result.put("nmcApproved", c.getNmcApproved());
        result.put("neetRequired", c.getNeetRequired());
        result.put("intake", c.getIntake());
        result.put("highlights", c.getHighlights());
        result.put("fees", c.getFees());
        result.put("eligibility", c.getEligibility());
        result.put("whyStudy", c.getWhyStudy());
        result.put("faqs", c.getFaqs());
        result.put("universities", uniList);

        return ResponseEntity.ok(result);
    }
}
