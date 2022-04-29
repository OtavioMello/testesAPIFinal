package com.project.test.cantina.repository;

import com.project.test.cantina.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
