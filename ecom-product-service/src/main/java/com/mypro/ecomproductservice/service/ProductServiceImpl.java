package com.mypro.ecomproductservice.service;

import com.mypro.ecomproductservice.dto.ProductDto;
import com.mypro.ecomproductservice.entity.Product;
import com.mypro.ecomproductservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        Product product = new Product();

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setStock(productDto.getStock());

        Product savedProduct = productRepository.save(product);

        return convertToDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));

        return convertToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setStock(productDto.getStock());

        Product updatedProduct = productRepository.save(product);

        return convertToDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found: " + id);
        }

        productRepository.deleteById(id);
    }

    private ProductDto convertToDto(Product product) {

        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        productDto.setStock(product.getStock());

        return productDto;
    }
}