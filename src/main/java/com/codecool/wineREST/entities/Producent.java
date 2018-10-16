package com.codecool.wineREST.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="producents")
public class Producent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_producent")
    private Long idProducent;
    private String name;


    public Producent() {
    }

    public Producent(String name) {
        this.name = name;
    }


    public Long getIdProducent() {
        return idProducent;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
