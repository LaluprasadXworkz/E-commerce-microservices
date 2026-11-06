package com.mypro.ecomproductservice.services;


import com.mypro.ecomproductservice.dto.ProductDto;
import com.mypro.ecomproductservice.entity.ProductEntity;
import com.mypro.ecomproductservice.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final RestTemplate template;
    private final ProductRepo productRepo;

    public ProductDto addProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDto, productEntity);
        ProductEntity savedEntity = productRepo.save(productEntity);
        ProductDto responseDto = new ProductDto();
        BeanUtils.copyProperties(savedEntity, responseDto);
        return responseDto;
    }









//
//    public ProductDto getProductById(Long id) {
//        Optional<ProductEntity> byId = productRepo.findById(id);
//        return byId.get();
//    }




}
