package com.example.fastmarket.mapper;

import com.example.fastmarket.dto.ProductRequest;
import com.example.fastmarket.dto.ProductResponse;
import com.example.fastmarket.model.Product;

public class ProductMapper {

    public static ProductResponse toResponseDTO(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductRequest dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

}
