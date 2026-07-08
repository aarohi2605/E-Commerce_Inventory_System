package com.ecommerce.grocery.controller;

import com.ecommerce.grocery.dto.DashboardDTO;
import com.ecommerce.grocery.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardDTO> getDashboard() {

        return ResponseEntity.ok(
                dashboardService.getDashboardDetails());

    }
}