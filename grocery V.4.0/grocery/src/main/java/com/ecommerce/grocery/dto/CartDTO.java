package com.ecommerce.grocery.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {

    private Long productId;

    private Integer quantity;

}