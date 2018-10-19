package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.WineArchive;
import org.springframework.data.repository.CrudRepository;

public interface WineArchiveRepository extends CrudRepository<WineArchive, Long> {
}
