package com.ecommerce.grocery.controller;

import com.ecommerce.grocery.dto.CartDTO;
import com.ecommerce.grocery.model.Cart;
import com.ecommerce.grocery.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addToCart(Authentication authentication,
                                          @RequestBody CartDTO cartDTO) {

        return ResponseEntity.ok(
                cartService.addToCart(authentication.getName(), cartDTO));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCart(Authentication authentication) {

        return ResponseEntity.ok(
                cartService.getCart(authentication.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long id) {

        cartService.removeFromCart(id);

        return ResponseEntity.ok("Item Removed From Cart");
    }
}