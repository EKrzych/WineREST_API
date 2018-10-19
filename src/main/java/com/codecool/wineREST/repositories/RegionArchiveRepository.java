package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.RegionArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RegionArchiveRepository extends CrudRepository<RegionArchive, Long> {
}
