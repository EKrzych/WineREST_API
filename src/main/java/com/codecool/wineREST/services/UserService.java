package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String firstName, String lastName) {
        this.userRepository.save(new User(username, firstName, lastName));
    }

    public Iterable<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public long getSize() {
        return this.userRepository.count();
    }

}
