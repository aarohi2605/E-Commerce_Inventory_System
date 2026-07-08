package com.ecommerce.grocery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String paymentMethod;

    private String paymentStatus;

    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}