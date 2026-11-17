package com.mypro.ecomproductservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;

    private String productName;

    private BigDecimal price;

    private String category;

    private Long stock;
}