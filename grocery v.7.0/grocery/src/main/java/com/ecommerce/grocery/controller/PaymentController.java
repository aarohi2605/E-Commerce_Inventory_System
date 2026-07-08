package com.ecommerce.grocery.controller;

import com.ecommerce.grocery.dto.PaymentDTO;
import com.ecommerce.grocery.model.Payment;
import com.ecommerce.grocery.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentDTO paymentDTO) {

        return ResponseEntity.ok(
                paymentService.makePayment(paymentDTO));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {

        return ResponseEntity.ok(
                paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {

        return ResponseEntity.ok(
                paymentService.getPaymentById(id));
    }
}