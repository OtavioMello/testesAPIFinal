package com.project.test.cantina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime localDate;
    private BigDecimal totalPrice = new BigDecimal(0);
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(LocalDateTime localDate, User user){
        this.localDate = localDate;
        this.user = user;
    }

}
