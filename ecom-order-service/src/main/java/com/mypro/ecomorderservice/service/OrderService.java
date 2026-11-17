package com.mypro.ecomorderservice.service;

import com.mypro.ecomorderservice.dto.CreateOrderRequest;
import com.mypro.ecomorderservice.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(CreateOrderRequest request);

    Order getOrderById(Long id);

    List<Order> getAllOrders();
}