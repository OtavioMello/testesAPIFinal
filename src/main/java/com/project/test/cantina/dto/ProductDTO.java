package com.project.test.cantina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal unityPrice;
    private int quantity;

}
