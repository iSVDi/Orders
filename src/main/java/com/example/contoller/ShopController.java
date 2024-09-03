package com.example.contoller;


import com.example.model.User;
import com.example.model.UserViews;
import com.example.service.ShopService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
@AllArgsConstructor
@Validated

public class ShopController {

    private final ShopService service;

    @PostMapping("createUser")
    void createUser(@Valid @RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping("readUser/{id}")
    User readUser(@Valid @PathVariable UUID id) {
        return service.readUser(id);
    }

    @GetMapping("readAllUsers")
    @JsonView(UserViews.UserSummary.class)
    List<User> readAll() {
        return service.readAllUsers();
    }

    @PutMapping("updateUser")
    void updateUser(@Valid @RequestBody User user) {
        service.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    void deleteUser(@PathVariable UUID id) {
        service.deleteUser(id);
    }


}
