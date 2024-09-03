package com.example.spring_mvc;

import com.example.model.Order;
import com.example.model.User;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    Order getSavedOrder() {
        Order order = Order.builder()
                .info("test info")
                .amount(BigDecimal.valueOf(123.45))
                .status("test status").build();

        orderRepository.save(order);
        return order;
    }

    User getSavedUserWithOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(getSavedOrder());

        User user = User.builder()
                .email("test@gmail.com")
                .name("Alex")
                .orders(orders)
                .build();
        User savedUser = userRepository.save(user);
        orders.get(0).setUser(savedUser);
        return user;
    }


    // create user
    @Test
    void createUser() {
        User user = getSavedUserWithOrder();
        Assertions.assertTrue(userRepository.existsById(user.getId()));
    }
    // read user
    @Test
    void readUser() {
        User user = getSavedUserWithOrder();
        User readUser = userRepository.findById(user.getId()).get();
        Assertions.assertEquals(user,readUser);
    }

    // update user
    @Test
    void updateUser() {
        User user = getSavedUserWithOrder();
        userRepository.save(user);

        User clone = user.clone();
        clone.setName("Bob");
        User savedUser = userRepository.save(user);

        Assertions.assertEquals(user.getName(), "Alex");
        Assertions.assertNotEquals(savedUser.getName(), "Bob");
    }

    // delete user
    @Test
    void deleteUser() {
        User user = getSavedUserWithOrder();
        userRepository.deleteById(user.getId());

        Assertions.assertFalse(userRepository.existsById(user.getId()));
    }

}
