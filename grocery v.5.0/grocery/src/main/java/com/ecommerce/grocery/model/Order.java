package com.ecommerce.grocery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    private Double totalAmount;

    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}