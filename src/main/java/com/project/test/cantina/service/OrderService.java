package com.project.test.cantina.service;

import com.project.test.cantina.constants.Status;
import com.project.test.cantina.dto.OrderDTO;
import com.project.test.cantina.dto.OrderFormDTO;
import com.project.test.cantina.dto.OrderedProductDTO;
import com.project.test.cantina.dto.StatusUpdateFormDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public OrderDTO postOrder(OrderFormDTO orderFormDTO) {

        Optional<User> optionalUser = userRepository.findById(orderFormDTO.getUserId());

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            Order order = new Order(LocalDateTime.now(), user);
            orderRepository.save(order);
            user.getOrders().add(order);
            userRepository.save(user);
            return modelMapper.map(order, OrderDTO.class);
        }
        return null;
    }

    public Page<OrderDTO> getOrder(Pageable pageable) {
        Page<Order> orders = orderRepository.findAll(pageable);
        List<OrderDTO> orderDTOList =
                orders.stream().map(o -> modelMapper.map(o, OrderDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(orderDTOList, pageable, orderDTOList.size());
    }

    public Page<OrderedProductDTO> getOrderProduct(Long orderId, Pageable pageable) {

        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()){
            Page<OrderedProduct> orderedProducts = orderedProductRepository.findByOrderId(orderId, pageable);
            List<OrderedProductDTO> orderedProductDTOList =
                    orderedProducts.stream().map(o ->
                            modelMapper.map(o, OrderedProductDTO.class)).collect(Collectors.toList());
            return new PageImpl<>(orderedProductDTOList, pageable, orderedProductDTOList.size());
        }
        return null;
    }

    public OrderDTO putOrderStatus(Long orderId, StatusUpdateFormDTO statusUpdateFormDTO) {

        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setStatus(statusUpdateFormDTO.getStatus());
            orderRepository.save(order);

            if (order.getStatus().equals(Status.NOT_WITHDRAWN)){
                List<OrderedProduct> orderedProducts = orderedProductRepository.findByOrderId(orderId);
                for (int i = 0; i < orderedProducts.size(); i++) {
                    Product product = orderedProducts.get(i).getProduct();
                    product.setQuantity(product.getQuantity() + 1);
                    productRepository.save(product);
                }
            return modelMapper.map(order, OrderDTO.class);
            }
        }
        return null;
    }
}
