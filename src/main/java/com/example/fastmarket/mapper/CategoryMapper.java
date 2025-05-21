package com.example.fastmarket.mapper;

import com.example.fastmarket.dto.request.CategoryRequest;
import com.example.fastmarket.dto.response.CategoryResponse;
import com.example.fastmarket.entities.Category;

public class CategoryMapper {

    public static CategoryResponse toResponseDTO(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

    public static Category toEntity(CategoryRequest dto) {
        Category category = new Category();
        category.setName(dto.name());
        category.setDescription(dto.description());
        return category;
    }

}
