package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.HealthCheckResponse;
import com.server.dosopt.seminar.dto.HealthCheckResponseDtoV1;
import com.server.dosopt.seminar.dto.HealthCheckResponseDtoV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheck1(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheck2(){
        return ResponseEntity.ok("OK GOGO");
    }

    @GetMapping("/v3")
    public String healthCheck3(){
        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheck4(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheck5(){
        return ResponseEntity.ok(new HealthCheckResponse("success"));
    }

    @GetMapping("/v6")
    public HealthCheckResponseDtoV1 healthCheck6(){
        return HealthCheckResponseDtoV1.success("200", "OK", true);
    }

    @GetMapping("/v7")
    public HealthCheckResponseDtoV2 healthCheck7(){
        HealthCheckResponseDtoV2 h = HealthCheckResponseDtoV2.builder()
                .code("200")
                .status("OK")
                .success(true)
                .build();

        return h;
    }
}
