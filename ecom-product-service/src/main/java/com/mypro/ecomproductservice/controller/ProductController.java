
package com.mypro.ecomproductservice.controller;

import com.mypro.ecomproductservice.dto.ProductDto;
import com.mypro.ecomproductservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }
//
//    @GetMapping("/{id}")
//    public ProductDto getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
}
