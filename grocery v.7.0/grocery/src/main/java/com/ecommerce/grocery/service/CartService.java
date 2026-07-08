package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.CartDTO;
import com.ecommerce.grocery.exception.ResourceNotFoundException;
import com.ecommerce.grocery.model.Cart;
import com.ecommerce.grocery.model.Product;
import com.ecommerce.grocery.model.User;
import com.ecommerce.grocery.repository.CartRepository;
import com.ecommerce.grocery.repository.ProductRepository;
import com.ecommerce.grocery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Cart addToCart(String email, CartDTO cartDTO) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Product product = productRepository.findById(cartDTO.getProductId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        Cart cart = Cart.builder()
                .user(user)
                .product(product)
                .quantity(cartDTO.getQuantity())
                .build();

        return cartRepository.save(cart);
    }

    public List<Cart> getCart(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return cartRepository.findByUserId(user.getId());
    }

    public void removeFromCart(Long id) {

        Cart cart = cartRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart item not found"));

        cartRepository.delete(cart);
    }
}