package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.entities.WineArchive;
import com.codecool.wineREST.repositories.WineArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineArchiveService {
    @Autowired
    WineArchiveRepository wineArchiveRepository;


    public void archive(Wine wine) {
        WineArchive wineArchive = new WineArchive(wine.getName(), wine.getVariety(), wine.getStyle(), wine.getType(), wine.getProducent(), wine.getRegion(), wine.getYear());
        this.wineArchiveRepository.save(wineArchive);
    }
}
