package com.project.test.cantina.controller;

import com.project.test.cantina.dto.*;
import com.project.test.cantina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> postUser(@RequestBody UserFormDTO userFormDTO){
        UserDTO user = userService.postUser(userFormDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/{userId}/order/{orderId}")
    public ResponseEntity<OrderedProductDTO> postProductIntoOrder
            (@PathVariable Long userId,
             @PathVariable Long orderId,
             @RequestBody OrderedProductFormDTO orderedProductFormDTO){

        OrderedProductDTO orderedProduct =
                userService.postProductIntoOrder(userId, orderId, orderedProductFormDTO);

        if (orderedProduct != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(orderedProduct);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public Page<UserDTO> getUser
            (@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<UserDTO> users = userService.getUser(pageable);
        return users;
    }

    @GetMapping("/{userId}/order")
    public Page<OrderForUserDTO> getUserOrder
            (@PathVariable Long userId,
             @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<OrderForUserDTO> userOrders = userService.getUserOrders(userId, pageable);
            return userOrders;
    }

}
