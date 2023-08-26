package com.springboot.project.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResources {
    private UserDaoService service;

    public UserResources(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        service.save(user);
    }
}
