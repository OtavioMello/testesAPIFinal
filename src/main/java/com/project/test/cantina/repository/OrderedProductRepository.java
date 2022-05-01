package com.project.test.cantina.repository;

import com.project.test.cantina.entities.OrderedProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
    Page<OrderedProduct> findByOrderId(Long orderId, Pageable pageable);
}
