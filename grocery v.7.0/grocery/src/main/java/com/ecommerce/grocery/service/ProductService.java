package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.ProductDTO;
import com.ecommerce.grocery.exception.ResourceNotFoundException;
import com.ecommerce.grocery.model.Category;
import com.ecommerce.grocery.model.Product;
import com.ecommerce.grocery.repository.CategoryRepository;
import com.ecommerce.grocery.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ecommerce.grocery.model.Supplier;
import com.ecommerce.grocery.repository.SupplierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found with id: " + productDTO.getCategoryId()));

        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found with id: " + productDTO.getSupplierId()));

        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .category(category)
                .supplier(supplier)
                .build();

        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found with id: " + productDTO.getCategoryId()));

        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found with id: " + productDTO.getSupplierId()));

        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(category);
        product.setSupplier(supplier);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));

        productRepository.delete(product);
    }

    public List<Product> searchProducts(String keyword) {

        return productRepository.findByProductNameContainingIgnoreCase(keyword);
    }

    public Page<Product> getProductsWithPagination(int page, int size) {

        return productRepository.findAll(PageRequest.of(page, size));
    }

    public List<Product> getProductsWithSorting(String field) {

        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
}