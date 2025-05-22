package com.example.fastmarket.service;

import com.example.fastmarket.dto.request.SupplierRequest;
import com.example.fastmarket.dto.response.SupplierResponse;
import com.example.fastmarket.entities.Supplier;
import com.example.fastmarket.mapper.SupplierMapper;
import com.example.fastmarket.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierService {

    @Autowired
    private final SupplierRepository supplierRepository;

    @Autowired
    private final SupplierMapper supplierMapper;

    public SupplierResponse save(SupplierRequest dto) {
        Supplier supplier = supplierMapper.toEntity(dto);
        return supplierMapper.toResponseDTO(supplierRepository.save(supplier));
    }

    public List<SupplierResponse> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public SupplierResponse getById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        return supplierMapper.toResponseDTO(supplier);
    }

    public SupplierResponse getByCnpj(String cnpj) {
        Supplier supplier = supplierRepository.findByCnpj(cnpj).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        return supplierMapper.toResponseDTO(supplier);
    }

    public SupplierResponse update(Long id, SupplierRequest dto) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        supplier.setName(dto.name());
        supplier.setCnpj(dto.cnpj());
        supplier.setPhone(dto.phone());
        supplier.setEmail(dto.email());
        return supplierMapper.toResponseDTO(supplierRepository.save(supplier));
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

}
