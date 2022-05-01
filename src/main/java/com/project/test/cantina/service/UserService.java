package com.project.test.cantina.service;

import com.project.test.cantina.dto.*;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderedProductRepository orderedProductRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO postUser(UserFormDTO userFormDTO) {
        User user = userRepository.save(modelMapper.map(userFormDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }

    public Page<UserDTO> getUser(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        List<UserDTO> userDTOList =
                users.stream().map(u -> modelMapper.map(u, UserDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(userDTOList, pageable, userDTOList.size());
    }

    public Page<UserOrderDTO> getUserOrders(Long userId, Pageable pageable) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()){
            Page<Order> orders = orderRepository.findByUserId(userId, pageable);
            List<UserOrderDTO> userOrderDTOList =
                    orders.stream().map(u -> modelMapper.map(u, UserOrderDTO.class)).collect(Collectors.toList());
            return new PageImpl<>(userOrderDTOList, pageable, userOrderDTOList.size());
        }
        return null;
    }

    public OrderedProductDTO postProductIntoOrder
            (Long userId, Long orderId, OrderedProductFormDTO orderedProductFormDTO) {

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Optional<Product> optionalProduct = productRepository.findById(orderedProductFormDTO.getProductId());

        if (optionalUser.isPresent() && optionalOrder.isPresent() && optionalProduct.isPresent()){

            Order order = optionalOrder.get();
            Product product = optionalProduct.get();

            OrderedProduct orderedProduct = null;
            int minusQuantity = 0;

            if(product.getQuantity() < orderedProductFormDTO.getOrderedQuantity()){
                throw new RuntimeException("Quantidade de produtos insuficiente!");
            }

            for (int i = 0; i < orderedProductFormDTO.getOrderedQuantity(); i++) {
                        orderedProduct =
                        new OrderedProduct(product.getName(),
                                product.getUnityPrice(), order, product);
                        order.setTotalPrice(order.getTotalPrice().add(product.getUnityPrice()));
                        orderRepository.save(order);
                orderedProductRepository.save(orderedProduct);
                minusQuantity++;
            }
            product.setQuantity(product.getQuantity() - minusQuantity);
            productRepository.save(product);
            return modelMapper.map(orderedProduct, OrderedProductDTO.class);
        }
        return  null;
    }
}
