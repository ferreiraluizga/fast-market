package com.example.fastmarket.mapper;

import com.example.fastmarket.dto.request.SupplierRequest;
import com.example.fastmarket.dto.response.SupplierResponse;
import com.example.fastmarket.entities.Supplier;

public class SupplierMapper {

    public static SupplierResponse toResponseDTO(Supplier supplier) {
        return new SupplierResponse(
                supplier.getId(),
                supplier.getName(),
                supplier.getCnpj(),
                supplier.getPhone(),
                supplier.getEmail()
        );
    }

    public static Supplier toEntity(SupplierRequest dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.name());
        supplier.setCnpj(dto.cnpj());
        supplier.setPhone(dto.phone());
        supplier.setEmail(dto.email());
        return supplier;
    }

}
