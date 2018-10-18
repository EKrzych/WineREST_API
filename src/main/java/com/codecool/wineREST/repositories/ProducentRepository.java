package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.entities.Wine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducentRepository extends CrudRepository<Producent, Long> {
    Producent findByName(String name);
    Producent findByIdProducent(long idProducent);
}
