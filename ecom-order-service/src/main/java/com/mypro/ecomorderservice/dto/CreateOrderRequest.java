package com.mypro.ecomorderservice.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long productId;

    private Long quantity;
}