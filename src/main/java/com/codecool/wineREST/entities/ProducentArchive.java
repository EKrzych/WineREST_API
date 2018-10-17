package com.codecool.wineREST.entities;

import javax.persistence.*;

@Entity
@Table(name="producents_archive")
public class ProducentArchive {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_producent")
    private Long idProducent;
    private String name;


    public ProducentArchive() {
    }

    public ProducentArchive(String name) {
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
