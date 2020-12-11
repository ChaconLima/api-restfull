package com.chacon.apirestfull.repository;

import com.chacon.apirestfull.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}