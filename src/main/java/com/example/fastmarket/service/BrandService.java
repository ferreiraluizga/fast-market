package com.example.fastmarket.service;

import com.example.fastmarket.dto.request.BrandRequest;
import com.example.fastmarket.dto.response.BrandResponse;
import com.example.fastmarket.entities.Brand;
import com.example.fastmarket.mapper.BrandMapper;
import com.example.fastmarket.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandService {

    @Autowired
    private final BrandRepository brandRepository;

    @Autowired
    private final BrandMapper brandMapper;

    public BrandResponse save(BrandRequest dto) {
        Brand brand = brandMapper.toEntity(dto);
        return brandMapper.toResponseDTO(brandRepository.save(brand));
    }

    public List<BrandResponse> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public BrandResponse getById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
        return brandMapper.toResponseDTO(brand);
    }

    public BrandResponse update(Long id, BrandRequest dto) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
        brand.setName(dto.name());
        brand.setDescription(dto.description());
        return brandMapper.toResponseDTO(brandRepository.save(brand));
    }

    public void delete(Long id) {
        brandRepository.deleteById(id);
    }

}
