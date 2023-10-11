package com.server.dosopt.seminar.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HealthCheckResponseDtoV1 {
    private String code;
    private String status;
    private boolean success;

    public static HealthCheckResponseDtoV1 success(String code, String status, boolean success) {
        return new HealthCheckResponseDtoV1(code, status, success);
    }
}
