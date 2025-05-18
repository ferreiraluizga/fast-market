package com.example.fastmarket.service;

import com.example.fastmarket.dto.ProductRequest;
import com.example.fastmarket.dto.ProductResponse;
import com.example.fastmarket.mapper.ProductMapper;
import com.example.fastmarket.model.Product;
import com.example.fastmarket.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductResponse save(ProductRequest dto) {
        Product product = ProductMapper.toEntity(dto);
        return ProductMapper.toResponseDTO(productRepository.save(product));
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponse update(Long id, ProductRequest dto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return ProductMapper.toResponseDTO(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
