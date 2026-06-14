package com.medufly.edu.controller;

import com.medufly.edu.entity.University;
import com.medufly.edu.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityRepository universityRepository;

    public UniversityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @GetMapping
    public List<University> listUniversities() {
        return universityRepository.findAll();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Map<String, Object>> getUniversity(@PathVariable String slug) {
        Optional<University> opt = universityRepository.findBySlug(slug);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        University u = opt.get();

        List<Map<String, Object>> related = universityRepository.findByCountrySlug(u.getCountrySlug())
            .stream()
            .filter(r -> !r.getSlug().equals(slug))
            .limit(3)
            .map(r -> {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("slug", r.getSlug());
                m.put("name", r.getName());
                m.put("city", r.getCity());
                m.put("totalFee", r.getTotalFee());
                return m;
            })
            .toList();

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id", u.getId());
        result.put("slug", u.getSlug());
        result.put("name", u.getName());
        result.put("countrySlug", u.getCountrySlug());
        result.put("country", u.getCountryName());
        result.put("countryName", u.getCountryName());
        result.put("flag", u.getFlag());
        result.put("city", u.getCity());
        result.put("founded", u.getFounded());
        result.put("nmc", u.getNmc());
        result.put("duration", u.getDuration());
        result.put("medium", u.getMedium());
        result.put("annualFee", u.getAnnualFee());
        result.put("hostelFee", u.getHostelFee());
        result.put("totalFee", u.getTotalFee());
        result.put("intake", u.getIntake());
        result.put("badge", u.getBadge());
        result.put("overview", u.getOverview());
        result.put("highlights", u.getHighlights());
        result.put("courses", u.getCourses());
        result.put("facilities", u.getFacilities());
        result.put("related", related);

        return ResponseEntity.ok(result);
    }
}
