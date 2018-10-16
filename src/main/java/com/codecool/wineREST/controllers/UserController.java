package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.repositories.UserRepository;
import com.codecool.wineREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<User> getAll() {
        return this.userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        this.userService.createUser(user.getUsername(), user.getFirstName(), user.getLastName());
    }
}
