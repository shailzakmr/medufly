package com.medufly.edu.service;

import com.medufly.edu.entity.Lead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class WhatsAppService {

    private static final Logger log = LoggerFactory.getLogger(WhatsAppService.class);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd MMM yyyy, h:mm a");

    @Value("${greenapi.instance-id:}")
    private String instanceId;

    @Value("${greenapi.token:}")
    private String token;

    @Value("${greenapi.recipient-number:918084842777}")
    private String recipientNumber;

    private final RestTemplate restTemplate;

    public WhatsAppService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendLeadNotification(Lead lead) {
        if (instanceId.isBlank() || token.isBlank()) {
            log.info("[WhatsApp] Green API not configured — skipping notification for lead {}", lead.getId());
            return;
        }

        String url = "https://api.green-api.com/waInstance" + instanceId + "/sendMessage/" + token;
        Map<String, String> body = Map.of(
            "chatId", recipientNumber + "@c.us",
            "message", buildMessage(lead)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                url, new HttpEntity<>(body, headers), String.class
            );
            log.info("[WhatsApp] Notification sent for lead {}. Status: {}", lead.getId(), response.getStatusCode());
        } catch (Exception e) {
            log.error("[WhatsApp] Failed to send notification for lead {}: {}", lead.getId(), e.getMessage());
        }
    }

    private String buildMessage(Lead lead) {
        String sourceLabel = switch (lead.getSource()) {
            case "apply"      -> "Apply Form";
            case "contact"    -> "Contact Form";
            case "counseling" -> "Counseling Form";
            default           -> lead.getSource();
        };
        String time = lead.getCreatedAt() != null ? lead.getCreatedAt().format(FMT) : "—";

        StringBuilder sb = new StringBuilder();
        sb.append("*New Lead — Medufly Website*\n\n");
        sb.append("*Name:* ").append(lead.getFullName()).append("\n");
        sb.append("*Phone:* ").append(lead.getPhone()).append("\n");

        if (notBlank(lead.getEmail()))
            sb.append("*Email:* ").append(lead.getEmail()).append("\n");

        if (notBlank(lead.getCity())) {
            sb.append("*City:* ").append(lead.getCity());
            if (notBlank(lead.getState())) sb.append(", ").append(lead.getState());
            sb.append("\n");
        }

        if (notBlank(lead.getPreferredCountry()))
            sb.append("*Preferred Country:* ").append(lead.getPreferredCountry()).append("\n");
        if (notBlank(lead.getSubject()))
            sb.append("*Subject:* ").append(lead.getSubject()).append("\n");

        sb.append("*Source:* ").append(sourceLabel).append("\n");
        sb.append("*Time:* ").append(time).append("\n");

        String notes = notBlank(lead.getNotes()) ? lead.getNotes() : lead.getMessage();
        if (notBlank(notes))
            sb.append("\n*Notes:* ").append(notes).append("\n");

        sb.append("\nReply: https://wa.me/91").append(lead.getPhone());
        return sb.toString();
    }

    private boolean notBlank(String s) {
        return s != null && !s.isBlank();
    }
}
