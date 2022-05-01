package com.project.test.cantina.controller;

import com.project.test.cantina.dto.OrderDTO;
import com.project.test.cantina.dto.OrderFormDTO;
import com.project.test.cantina.dto.OrderedProductDTO;
import com.project.test.cantina.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> postOrder(@RequestBody OrderFormDTO orderFormDTO){
        OrderDTO order = orderService.postOrder(orderFormDTO);
        if (order != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page<OrderDTO> getOrder(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<OrderDTO> orders = orderService.getOrder(pageable);
        return orders;
    }

    @GetMapping("/{orderId}/product")
    public Page<OrderedProductDTO> getOrderProduct
            (@PathVariable Long orderId,
             @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<OrderedProductDTO> orderedProducts = orderService.getOrderProduct(orderId, pageable);
        return orderedProducts;
    }

}
