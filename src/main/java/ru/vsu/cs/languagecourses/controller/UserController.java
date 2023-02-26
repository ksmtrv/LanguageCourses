package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.UsersDto;
import ru.vsu.cs.languagecourses.entity.Users;
import ru.vsu.cs.languagecourses.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<UsersDto> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/user/new")
    public void addNewUser(@RequestBody Users users) {
        service.saveNewUser(users);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Users users) {
        service.updateUser(id, users);
    }
}
