package com.example.service;

import com.example.exception.ShopException;
import com.example.exception.ShopExceptionType;
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
        user.getOrders().forEach(order -> {
            order.setUser(savedUser);
            orderRepository.save(order);
        });

    }

    public User readUser(UUID id) throws ShopException {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            List<Order> orderList = orderRepository.findByUser(user);
            user.setOrders(orderList);
            return user;
        }
        throw new ShopException(ShopExceptionType.USER_NOT_EXISTS);
    }

    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            User savedUser = userRepository.save(user);
            user.getOrders().forEach(order -> {
                order.setUser(savedUser);
                orderRepository.save(order);
            });
        } else
            throw new ShopException(ShopExceptionType.USER_NOT_EXISTS);

    }

    public void deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else
            throw new ShopException(ShopExceptionType.USER_NOT_EXISTS);
    }
}
