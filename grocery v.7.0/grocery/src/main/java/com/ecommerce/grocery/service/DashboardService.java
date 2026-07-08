package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.DashboardDTO;
import com.ecommerce.grocery.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public DashboardDTO getDashboardDetails() {

        return DashboardDTO.builder()
                .totalProducts(productRepository.count())
                .totalCategories(categoryRepository.count())
                .totalSuppliers(supplierRepository.count())
                .totalCustomers(userRepository.count())
                .totalOrders(orderRepository.count())
                .totalPayments(paymentRepository.count())
                .build();
    }
}