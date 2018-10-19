package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findByCountry(String country);
    Region findByName(String name);
    Region findByIdRegion(long idRegion);
}
