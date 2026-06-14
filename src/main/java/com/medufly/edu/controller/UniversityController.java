package com.medufly.edu.controller;

import com.medufly.edu.entity.University;
import com.medufly.edu.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<University> getUniversity(@PathVariable String slug) {
        Optional<University> opt = universityRepository.findBySlug(slug);
        return opt.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
}
