package com.server.dosopt.seminar.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HealthCheckResponseDtoV2 {
    private String code;
    private String status;
    private boolean success;
}
