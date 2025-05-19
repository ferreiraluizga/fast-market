package com.example.fastmarket.service;

import com.example.fastmarket.dto.request.ProductRequest;
import com.example.fastmarket.dto.response.ProductResponse;
import com.example.fastmarket.mapper.ProductMapper;
import com.example.fastmarket.entities.Product;
import com.example.fastmarket.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return ProductMapper.toResponseDTO(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
