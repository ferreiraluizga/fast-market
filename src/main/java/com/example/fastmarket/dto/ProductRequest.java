package com.example.fastmarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;

    private String name;

    private String description;

    private Double price;

}
