package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.entities.UserArchive;
import com.codecool.wineREST.repositories.UserArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserArchiveService {

    @Autowired
    UserArchiveRepository userArchiveRepository;

    public void archive(User user) {
        UserArchive userArchive = new UserArchive(user.getUsername(), user.getFirstName(), user.getLastName());
        this.userArchiveRepository.save(userArchive);
    }
}
