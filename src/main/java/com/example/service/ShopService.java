package com.example.service;


import com.example.model.User;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        //TODO implement adding orders
        User user = userRepository.findById(id).get();
        return user;
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
