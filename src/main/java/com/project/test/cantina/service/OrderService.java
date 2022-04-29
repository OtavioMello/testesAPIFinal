package com.project.test.cantina.service;

import com.project.test.cantina.dto.OrderDTO;
import com.project.test.cantina.dto.OrderFormDTO;
import com.project.test.cantina.entities.Order;
import com.project.test.cantina.entities.OrderedProduct;
import com.project.test.cantina.entities.Product;
import com.project.test.cantina.entities.User;
import com.project.test.cantina.repository.OrderRepository;
import com.project.test.cantina.repository.OrderedProductRepository;
import com.project.test.cantina.repository.ProductRepository;
import com.project.test.cantina.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderedProductRepository orderedProductRepository;
    @Autowired
    private ModelMapper modelMapper;

}
