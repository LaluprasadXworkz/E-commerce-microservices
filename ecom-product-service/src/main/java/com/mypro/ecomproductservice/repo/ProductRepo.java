package com.mypro.ecomproductservice.repo;

import com.mypro.ecomproductservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
}
