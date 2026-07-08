package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.OrderDTO;
import com.ecommerce.grocery.exception.ResourceNotFoundException;
import com.ecommerce.grocery.model.Order;
import com.ecommerce.grocery.model.User;
import com.ecommerce.grocery.repository.OrderRepository;
import com.ecommerce.grocery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public Order placeOrder(String email, OrderDTO orderDTO) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Order order = Order.builder()
                .orderDate(LocalDate.now())
                .totalAmount(orderDTO.getTotalAmount())
                .orderStatus(orderDTO.getOrderStatus())
                .user(user)
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getMyOrders(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return orderRepository.findByUserId(user.getId());
    }

    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id: " + id));
    }
}