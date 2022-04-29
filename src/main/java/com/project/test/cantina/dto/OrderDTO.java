package com.project.test.cantina.dto;

import com.project.test.cantina.entities.OrderedProduct;
import com.project.test.cantina.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Long id;
    private LocalDateTime localDate;
    private User user;
    private List<OrderedProduct> orderedProduct;

}
