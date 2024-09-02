package com.example.service;


import com.example.model.Order;
import com.example.model.User;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShopService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public void createUser(User user) {
        User savedUser = userRepository.save(user);
        user.getOrders().stream().forEach( order -> {
            order.setUser(savedUser);
            orderRepository.save(order);
        });

    }

    public User readUser(UUID id) {
        User user = userRepository.findById(id).get();
        List<Order> orderList = orderRepository.findByUser(user);
        user.setOrders(orderList);
        return user;
    }

    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
