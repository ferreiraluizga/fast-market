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

    @Autowired
    private final ProductMapper productMapper;

    public ProductResponse save(ProductRequest dto) {
        Product product = productMapper.toEntity(dto);
        return productMapper.toResponseDTO(productRepository.save(product));
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return productMapper.toResponseDTO(product);
    }

    public ProductResponse update(Long id, ProductRequest dto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return productMapper.toResponseDTO(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
