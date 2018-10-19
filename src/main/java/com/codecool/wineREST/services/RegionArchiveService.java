package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.entities.RegionArchive;
import com.codecool.wineREST.repositories.RegionArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionArchiveService {
    @Autowired
    RegionArchiveRepository regionArchiveRepository;

    public void archive(Region region) {
        RegionArchive regionArchive = new RegionArchive(region.getName(), region.getCountry());
        this.regionArchiveRepository.save(regionArchive);
    }
}
