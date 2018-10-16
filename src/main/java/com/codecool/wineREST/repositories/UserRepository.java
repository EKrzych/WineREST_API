package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
