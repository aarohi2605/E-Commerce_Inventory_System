package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.PaymentDTO;
import com.ecommerce.grocery.exception.ResourceNotFoundException;
import com.ecommerce.grocery.model.Order;
import com.ecommerce.grocery.model.Payment;
import com.ecommerce.grocery.repository.OrderRepository;
import com.ecommerce.grocery.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public Payment makePayment(PaymentDTO paymentDTO) {

        Order order = orderRepository.findById(paymentDTO.getOrderId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id: " + paymentDTO.getOrderId()));

        Payment payment = Payment.builder()
                .amount(paymentDTO.getAmount())
                .paymentMethod(paymentDTO.getPaymentMethod())
                .paymentStatus(paymentDTO.getPaymentStatus())
                .paymentDate(LocalDate.now())
                .order(order)
                .build();

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Payment not found with id: " + id));
    }
}