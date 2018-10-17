package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.repositories.ProducentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducentService {
    @Autowired
    private ProducentRepository producentRepository;

    @Autowired
    public ProducentService(ProducentRepository producerRepository){
        this.producentRepository = producerRepository;
    }

    public void createProducent(String name) {
        this.producentRepository.save(new Producent(name));
    }

    public Iterable<Producent> getAll() {
        return this.producentRepository.findAll();
    }

    public Producent findByName(String name) {
        return this.producentRepository.findByName(name);
    }

    public Producent findById(long idProducent) {
        return this.producentRepository.findByIdProducent(idProducent);
    }

    public void deleteProducent(Producent producent) {
        this.producentRepository.delete(producent);
    }
}
