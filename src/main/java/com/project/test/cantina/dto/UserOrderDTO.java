package com.project.test.cantina.dto;

import com.project.test.cantina.entities.OrderedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOrderDTO {

    private Long id;
    private LocalDateTime localDate;
    private BigDecimal totalPrice;

}
