package com.server.dosopt.seminar.dto;

import lombok.Data;

public class HealthCheckResponse {

    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse(String status) {
        this.status = status;
    }
}
