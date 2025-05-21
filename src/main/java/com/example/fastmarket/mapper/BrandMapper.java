package com.example.fastmarket.mapper;

import com.example.fastmarket.dto.request.BrandRequest;
import com.example.fastmarket.dto.response.BrandResponse;
import com.example.fastmarket.entities.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public BrandResponse toResponseDTO(Brand brand) {
        return new BrandResponse(
                brand.getId(),
                brand.getName(),
                brand.getDescription()
        );
    }

    public Brand toEntity(BrandRequest dto) {
        Brand brand = new Brand();
        brand.setName(dto.name());
        brand.setDescription(dto.description());
        return brand;
    }

}
