package com.codecool.wineREST.entities;

import javax.persistence.*;

@Entity
@Table(name="regions_archive")
public class RegionArchive {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_region")
    private Long idRegion;
    private  String name;
    private String country;

    public RegionArchive(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public RegionArchive() {
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
