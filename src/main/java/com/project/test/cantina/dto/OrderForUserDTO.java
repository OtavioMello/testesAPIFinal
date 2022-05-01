package com.project.test.cantina.dto;

import com.project.test.cantina.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderForUserDTO {

    private Long id;
    private LocalDateTime localDate;
    private BigDecimal totalPrice;
    private Status status;

}
