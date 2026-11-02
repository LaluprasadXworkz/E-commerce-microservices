package com.mypro.ecomorderservice.service;

import com.mypro.ecomorderservice.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final RestClient restClient;

    public OrderService(RestTemplate restTemplate, RestClient restClient) {
        this.restTemplate = restTemplate;
        this.restClient = restClient;
    }


    public String placeOrder(String id) {
        System.out.println("calling product service");
//        String product =   restTemplate.getForObject("http://localhost:8081/products/" + id, String.class);

      ResponseEntity<String> product =  restClient.get()
              .uri("http://localhost:8081/products/" + id)
              .retrieve()
              .toEntity(
                      String.class
              );

        System.out.println(product.getBody());
        System.out.println(product.getStatusCode());
        System.out.println(product.getHeaders());
        System.out.println(product.getHeaders().get("Content-Type"));
        System.out.println(product.getHeaders().get("Content-Length"));

       return  "IN Stock".equals(product.getBody()) ?"Order placed":"Product Out od Stock";

    }

    public String addOrder(ProductDto productDto) {

       ResponseEntity<ProductDto> entity = restClient.post()
                .uri("http://localhost:8081/products")
                .body(productDto)
                .retrieve()
                .toEntity(ProductDto.class);

       return (entity.getBody()!=null) ? "Product added" : "Product not added";

    }


}
