package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.repositories.WineRatingRepository;
import com.codecool.wineREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;
    private WineRatingRepository wineRatingRepository;

    @Autowired
    public UserController(UserService userService, WineRatingRepository wineRatingRepository) {
        this.userService = userService;
        this.wineRatingRepository = wineRatingRepository;
    }

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<User> getAll() {
        return this.userService.getAll();
    }

    @RequestMapping(path = "/{username}/ratings", method = RequestMethod.GET)
    Iterable<WineRating> getAllUsersRatings(@PathVariable(value = "username") String username) {
        return this.wineRatingRepository.findByPkUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        this.userService.createUser(user.getUsername(), user.getFirstName(), user.getLastName());
    }
}
