package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.entities.UserArchive;
import org.springframework.data.repository.CrudRepository;

public interface UserArchiveRepository extends CrudRepository<UserArchive, String> {
}
