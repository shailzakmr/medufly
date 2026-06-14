package com.medufly.edu.service;

import com.medufly.edu.dto.ApplyRequest;
import com.medufly.edu.dto.ContactRequest;
import com.medufly.edu.dto.CounselingRequest;
import com.medufly.edu.entity.Lead;
import com.medufly.edu.repository.LeadRepository;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final WhatsAppService whatsAppService;

    public LeadService(LeadRepository leadRepository, WhatsAppService whatsAppService) {
        this.leadRepository = leadRepository;
        this.whatsAppService = whatsAppService;
    }

    public void handleApply(ApplyRequest req) {
        Lead lead = Lead.builder()
                .fullName(req.getFullName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .city(req.getCity())
                .state(req.getState())
                .notes(req.getNotes())
                .source("apply")
                .build();
        saveAndNotify(lead);
    }

    public void handleContact(ContactRequest req) {
        Lead lead = Lead.builder()
                .fullName(req.getName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .subject(req.getSubject())
                .message(req.getMessage())
                .source("contact")
                .build();
        saveAndNotify(lead);
    }

    public void handleCounseling(CounselingRequest req) {
        Lead lead = Lead.builder()
                .fullName(req.getName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .city(req.getCity())
                .preferredCountry(req.getCountry())
                .source("counseling")
                .build();
        saveAndNotify(lead);
    }

    private void saveAndNotify(Lead lead) {
        Lead saved = leadRepository.save(lead);
        whatsAppService.sendLeadNotification(saved);
    }
}
