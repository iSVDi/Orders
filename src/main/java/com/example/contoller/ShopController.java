package com.example.contoller;


import com.example.model.User;
import com.example.model.UserViews;
import com.example.service.ShopService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @JsonView(UserViews.UserDetails.class)
    User readUser(@PathVariable UUID id) {
        return service.readUser(id);
    }
//
    @PutMapping("updateUser")
    void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }
//
    @DeleteMapping("deleteUser/{id}")
    void deleteUser(@PathVariable UUID id) {
        service.deleteUser(id);
    }
//






}
