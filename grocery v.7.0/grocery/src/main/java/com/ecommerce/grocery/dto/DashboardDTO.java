package com.ecommerce.grocery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardDTO {

    private Long totalProducts;

    private Long totalCategories;

    private Long totalSuppliers;

    private Long totalCustomers;

    private Long totalOrders;

    private Long totalPayments;
}