package com.cg.securitydemo.productms.repository;

import com.cg.securitydemo.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
