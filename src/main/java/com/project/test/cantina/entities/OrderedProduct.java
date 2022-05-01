package com.project.test.cantina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ordered_product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int orderedQuantity;
    private BigDecimal unityPrice;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;

    public OrderedProduct(String name ,BigDecimal unityPrice, Order order, Product product){
        this.name = name;
        this.unityPrice = unityPrice;
        this.order = order;
        this.product = product;
    }

}

