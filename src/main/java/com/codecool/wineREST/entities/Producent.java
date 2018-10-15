package com.codecool.wineREST.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_producent")
    private Long idProducent;
    private String name;



    public Producent(Long idProducent, String name) {
        this.idProducent = idProducent;
        this.name = name;
    }

    public Long getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(Long idProducent) {
        this.idProducent = idProducent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
