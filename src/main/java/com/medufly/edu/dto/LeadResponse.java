package com.medufly.edu.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LeadResponse {
    private boolean success;
    private String message;

    public static LeadResponse ok(String message) {
        return new LeadResponse(true, message);
    }

    public static LeadResponse error(String message) {
        return new LeadResponse(false, message);
    }
}
