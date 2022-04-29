package com.project.test.cantina.repository;

import com.project.test.cantina.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
