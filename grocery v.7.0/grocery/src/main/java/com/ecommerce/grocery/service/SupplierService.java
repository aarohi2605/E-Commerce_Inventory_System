package com.ecommerce.grocery.service;

import com.ecommerce.grocery.dto.SupplierDTO;
import com.ecommerce.grocery.exception.ResourceNotFoundException;
import com.ecommerce.grocery.model.Supplier;
import com.ecommerce.grocery.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {

        return supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found with id : " + id));
    }

    public Supplier createSupplier(SupplierDTO supplierDTO) {

        Supplier supplier = Supplier.builder()
                .supplierName(supplierDTO.getSupplierName())
                .contactNumber(supplierDTO.getContactNumber())
                .address(supplierDTO.getAddress())
                .build();

        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, SupplierDTO supplierDTO) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found with id : " + id));

        supplier.setSupplierName(supplierDTO.getSupplierName());
        supplier.setContactNumber(supplierDTO.getContactNumber());
        supplier.setAddress(supplierDTO.getAddress());

        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found with id : " + id));

        supplierRepository.delete(supplier);
    }
}