package com.codecool.wineREST.repositories;


import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.entities.Wine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WineRepository extends CrudRepository<Wine, Long> {
    List<Wine> findByName(String name);
    List<Wine> findByRegion(Region Region);
    List<Wine> findByStyle(String style);
    List<Wine> findByType(String type);
    List<Wine> findByVariety(String variety);

    Wine findByIdWine(long idWine);
}

