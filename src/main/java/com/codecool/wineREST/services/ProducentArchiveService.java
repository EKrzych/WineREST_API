package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.entities.ProducentArchive;
import com.codecool.wineREST.repositories.ProducentArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducentArchiveService {

    @Autowired
    ProducentArchiveRepository producentArchiveRepository;

    public void archive(Producent producent) {
        ProducentArchive producentArchive = new ProducentArchive(producent.getName());
        this.producentArchiveRepository.save(producentArchive);
    }
}
