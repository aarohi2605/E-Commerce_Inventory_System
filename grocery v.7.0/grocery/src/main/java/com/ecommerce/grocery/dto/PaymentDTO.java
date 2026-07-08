package com.ecommerce.grocery.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {

    private Double amount;

    private String paymentMethod;

    private String paymentStatus;

    private Long orderId;

}