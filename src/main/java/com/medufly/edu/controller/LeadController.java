package com.medufly.edu.controller;

import com.medufly.edu.dto.*;
import com.medufly.edu.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping("/apply")
    public ResponseEntity<LeadResponse> apply(@Valid @RequestBody ApplyRequest req) {
        leadService.handleApply(req);
        return ResponseEntity.ok(LeadResponse.ok("Application received. Our counselor will contact you within 24 hours."));
    }

    @PostMapping("/contact")
    public ResponseEntity<LeadResponse> contact(@Valid @RequestBody ContactRequest req) {
        leadService.handleContact(req);
        return ResponseEntity.ok(LeadResponse.ok("Message received. Our team will get back to you within 24 hours."));
    }

    @PostMapping("/counseling")
    public ResponseEntity<LeadResponse> counseling(@Valid @RequestBody CounselingRequest req) {
        leadService.handleCounseling(req);
        return ResponseEntity.ok(LeadResponse.ok("Thank you! Our counselor will call you within 24 hours."));
    }
}
