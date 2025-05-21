package com.example.fastmarket.mapper;

import com.example.fastmarket.dto.request.ProductRequest;
import com.example.fastmarket.dto.response.ProductResponse;
import com.example.fastmarket.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse toResponseDTO(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public Product toEntity(ProductRequest dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return product;
    }

}
