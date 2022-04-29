package com.project.test.cantina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "ordered_product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int orderedQuantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
