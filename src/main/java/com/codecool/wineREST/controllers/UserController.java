package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.exceptions.FkViolationException;
import com.codecool.wineREST.repositories.WineRatingRepository;
import com.codecool.wineREST.services.UserArchiveService;
import com.codecool.wineREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;
    private UserArchiveService userArchiveService;
    private WineRatingRepository wineRatingRepository;

    @Autowired
    public UserController(UserService userService, WineRatingRepository wineRatingRepository, UserArchiveService userArchiveService) {
        this.userService = userService;
        this.wineRatingRepository = wineRatingRepository;
        this.userArchiveService = userArchiveService;
    }

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<User> getAll() {
        return this.userService.getAll();
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    User getByUsername(@PathVariable(value = "username") String username) {
        User user = this.userService.getByUsername(username);
        if(user == null) {
            throw new NoSuchElementException("There is no user: " + username);
        }
        return user;
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void archiveUser(@PathVariable(value = "username") String username) throws NoSuchElementException {
        User user = this.userService.getByUsername(username);
        if(user == null) {
            throw new NoSuchElementException("There is no user: " + username);
        }

        this.userArchiveService.archive(user);
        this.userService.deleteUser(user);
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
