package com.ecommerce.grocery.dto;

import com.ecommerce.grocery.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfileDTO {

    private String name;
    private String email;
    private Role role;

}