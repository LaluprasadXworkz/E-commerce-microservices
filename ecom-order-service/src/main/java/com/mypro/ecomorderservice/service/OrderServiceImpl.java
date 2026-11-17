package com.mypro.ecomorderservice.service;

import com.mypro.ecomorderservice.client.ProductClient;
import com.mypro.ecomorderservice.dto.CreateOrderRequest;
import com.mypro.ecomorderservice.dto.ProductDto;
import com.mypro.ecomorderservice.entity.Order;
import com.mypro.ecomorderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Override
    public Order placeOrder(CreateOrderRequest request) {

        // 1. Fetch product details from Product Service
        ProductDto product = productClient.getProductById(request.getProductId());

        // 2. Calculate total amount
        BigDecimal totalAmount = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));

        // 3. Create Order entity
        Order order = new Order();

        order.setProductId(product.getId());
        order.setProductName(product.getProductName());
        order.setPrice(product.getPrice());
        order.setQuantity(request.getQuantity());
        order.setTotalAmount(totalAmount);

        // 4. Save order in Order Service database
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {

        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }
}