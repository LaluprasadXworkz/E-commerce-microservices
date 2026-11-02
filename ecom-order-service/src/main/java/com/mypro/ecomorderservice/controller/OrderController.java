package com.mypro.ecomorderservice.controller;

import com.mypro.ecomorderservice.dto.ProductDto;
import com.mypro.ecomorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String addOrder(@RequestBody ProductDto productDto) {
        return orderService.addOrder(productDto);
    }

    @GetMapping("/{productId}")
    public String placeOrder(@PathVariable String productId) {
        return orderService.placeOrder(productId);
    }
}
