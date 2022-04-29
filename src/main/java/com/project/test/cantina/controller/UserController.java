package com.project.test.cantina.controller;

import com.project.test.cantina.dto.UserDTO;
import com.project.test.cantina.dto.UserFormDTO;
import com.project.test.cantina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
