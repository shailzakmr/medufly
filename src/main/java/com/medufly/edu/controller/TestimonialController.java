package com.medufly.edu.controller;

import com.medufly.edu.entity.Testimonial;
import com.medufly.edu.repository.TestimonialRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    private final TestimonialRepository testimonialRepository;

    public TestimonialController(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @GetMapping
    public List<Testimonial> listTestimonials() {
        return testimonialRepository.findByActiveTrueOrderByIdAsc();
    }
}
