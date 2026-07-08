package com.ecommerce.grocery.controller;

import com.ecommerce.grocery.dto.OrderDTO;
import com.ecommerce.grocery.model.Order;
import com.ecommerce.grocery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(Authentication authentication,
                                            @RequestBody OrderDTO orderDTO) {

        return ResponseEntity.ok(
                orderService.placeOrder(authentication.getName(), orderDTO));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getMyOrders(Authentication authentication) {

        return ResponseEntity.ok(
                orderService.getMyOrders(authentication.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

        return ResponseEntity.ok(
                orderService.getOrderById(id));
    }
}