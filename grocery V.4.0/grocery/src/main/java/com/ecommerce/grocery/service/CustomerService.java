package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.CustomerProfileDTO;
import com.ecommerce.grocery.model.User;
import com.ecommerce.grocery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final UserRepository userRepository;

    public CustomerProfileDTO getProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return new CustomerProfileDTO(
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}