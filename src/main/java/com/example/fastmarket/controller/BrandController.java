package com.example.fastmarket.controller;

import com.example.fastmarket.dto.request.BrandRequest;
import com.example.fastmarket.dto.response.BrandResponse;
import com.example.fastmarket.entities.Brand;
import com.example.fastmarket.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandResponse> save(@RequestBody BrandRequest dto) {
        BrandResponse response = brandService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAll() {
        List<BrandResponse> brands = brandService.getAll();
        return ResponseEntity.ok(brands);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> update(@PathVariable Long id, @RequestBody BrandRequest dto) {
        BrandResponse response = brandService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
