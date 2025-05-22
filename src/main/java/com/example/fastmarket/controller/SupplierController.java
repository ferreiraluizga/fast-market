package com.example.fastmarket.controller;

import com.example.fastmarket.dto.request.SupplierRequest;
import com.example.fastmarket.dto.response.SupplierResponse;
import com.example.fastmarket.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/save")
    public ResponseEntity<SupplierResponse> save(@RequestBody SupplierRequest dto) {
        SupplierResponse response = supplierService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAll() {
        List<SupplierResponse> suppliers = supplierService.getAll();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> getById(Long id) {
        SupplierResponse response = supplierService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<SupplierResponse> getByCnpj(String cnpj) {
        return ResponseEntity.ok(supplierService.getByCnpj(cnpj));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierResponse> update(@PathVariable Long id, @RequestBody SupplierRequest dto) {
        SupplierResponse response = supplierService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
