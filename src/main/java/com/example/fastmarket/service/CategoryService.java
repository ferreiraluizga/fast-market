package com.example.fastmarket.service;

import com.example.fastmarket.dto.request.CategoryRequest;
import com.example.fastmarket.dto.response.CategoryResponse;
import com.example.fastmarket.entities.Category;
import com.example.fastmarket.mapper.CategoryMapper;
import com.example.fastmarket.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryMapper categoryMapper;

    public CategoryResponse save(CategoryRequest dto) {
        Category category = categoryMapper.toEntity(dto);
        return categoryMapper.toResponseDTO(categoryRepository.save(category));
    }

    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponse update(Long id, CategoryRequest dto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        category.setName(dto.name());
        category.setDescription(dto.description());
        return categoryMapper.toResponseDTO(categoryRepository.save(category));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
