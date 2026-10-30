package com.mypro.ecomproductservice.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate template;

    public ProductService(RestTemplate template) {
        this.template = template;
    }

    public String getProductById(String id) {
        return id.equals("1")? "IN Stock" : "Out of Stock";
    }

}
