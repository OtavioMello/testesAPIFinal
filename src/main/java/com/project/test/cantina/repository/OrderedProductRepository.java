package com.project.test.cantina.repository;

import com.project.test.cantina.entities.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
}
