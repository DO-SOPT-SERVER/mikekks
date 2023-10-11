package com.server.dosopt.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HealthCheckResponseDtoV2 {
    private String code;
    private String status;
    private boolean success;

    @Builder
    public HealthCheckResponseDtoV2(String code, String status, boolean success) {
        this.code = code;
        this.status = status;
        this.success = success;
    }
}

