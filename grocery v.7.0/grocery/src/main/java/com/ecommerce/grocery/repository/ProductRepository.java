package com.ecommerce.grocery.repository;

import com.ecommerce.grocery.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContainingIgnoreCase(String keyword);

    Page<Product> findAll(Pageable pageable);

    List<Product> findAll(Sort sort);

}