package com.example.boilerplate.BoilerPlate.repository;


import com.example.boilerplate.BoilerPlate.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
