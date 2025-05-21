package com.example.fastmarket.mapper;

import com.example.fastmarket.dto.request.CategoryRequest;
import com.example.fastmarket.dto.response.CategoryResponse;
import com.example.fastmarket.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponseDTO(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

    public Category toEntity(CategoryRequest dto) {
        Category category = new Category();
        category.setName(dto.name());
        category.setDescription(dto.description());
        return category;
    }

}
