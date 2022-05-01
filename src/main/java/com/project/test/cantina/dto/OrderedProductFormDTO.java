package com.project.test.cantina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderedProductFormDTO {

    private int orderedQuantity;
    private Long productId;

}
