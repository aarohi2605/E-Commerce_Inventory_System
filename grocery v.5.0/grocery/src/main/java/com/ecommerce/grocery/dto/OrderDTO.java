package com.ecommerce.grocery.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Double totalAmount;

    private String orderStatus;

}