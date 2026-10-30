package com.mypro.ecomorderservice.controller;

import com.mypro.ecomorderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/{orderId}")
    public String placeOrder(@PathVariable("orderId") String id) {
        return orderService.placeOrder(id);
    }



}
