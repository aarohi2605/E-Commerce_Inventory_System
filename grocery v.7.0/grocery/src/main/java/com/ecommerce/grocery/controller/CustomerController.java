package com.ecommerce.grocery.controller;

import com.ecommerce.grocery.dto.CustomerProfileDTO;
import com.ecommerce.grocery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/profile")
    public CustomerProfileDTO getProfile(Authentication authentication) {

        return customerService.getProfile(authentication.getName());

    }
}