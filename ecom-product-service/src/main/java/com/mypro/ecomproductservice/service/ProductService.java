package com.mypro.ecomproductservice.service;

import com.mypro.ecomproductservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}