package com.codecool.wineREST.entities;

import javax.persistence.*;
@Entity
@Table(name="regions")
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_region")
    private Long idRegion;
    private  String name;
    private String country;

    public Region(Long idRegion, String name, String country) {
        this.idRegion = idRegion;
        this.name = name;
        this.country = country;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
