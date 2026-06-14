package com.medufly.edu.repository;

import com.medufly.edu.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {
    Optional<University> findBySlug(String slug);
    List<University> findByCountrySlug(String countrySlug);
}
