package com.example.contoller;


import com.example.model.User;
import com.example.model.UserViews;
import com.example.service.ShopService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
@AllArgsConstructor
public class ShopController {

    private final ShopService service;

    @PostMapping("createUser")
    void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping("readUser/{id}")
    User readUser(@PathVariable UUID id) {
        return service.readUser(id);
    }

    @GetMapping("readAllUsers")
    @JsonView(UserViews.UserSummary.class)
    List<User> readAll() {
        return service.readAllUsers();
    }

    @PutMapping("updateUser")
    void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    void deleteUser(@PathVariable UUID id) {
        service.deleteUser(id);
    }


}
