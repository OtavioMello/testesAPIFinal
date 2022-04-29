package com.project.test.cantina.controller;

import com.project.test.cantina.dto.OrderDTO;
import com.project.test.cantina.dto.OrderFormDTO;
import com.project.test.cantina.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @PostMapping
//    public ResponseEntity<OrderDTO> postOrder(@RequestBody OrderFormDTO orderFormDto){
//    }
}
