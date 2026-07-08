package com.ecommerce.grocery.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    private String name;
    private String email;
    private String password;

}