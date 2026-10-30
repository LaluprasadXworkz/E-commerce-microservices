package com.mypro.ecomorderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String placeOrder(String id) {
        System.out.println("calling product service");
        String product =   restTemplate.getForObject("http://localhost:8081/products/" + id, String.class);
       return  "IN Stock".equals(product) ?"Order placed":"Product Out od Stock";

    }
}
