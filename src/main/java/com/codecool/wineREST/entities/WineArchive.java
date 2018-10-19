package com.codecool.wineREST.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="wines_archive")
public class WineArchive {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_wine")
    private Long idWine;
    private String name;
    private String variety;
    private String style;
    private String type;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_producent")
    private Producent producent;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_region")
    private Region region;
    private LocalDate year;

    public WineArchive(String name, String variety, String style, String type, @NotNull Producent producent, @NotNull Region region, LocalDate year) {
        this.name = name;
        this.variety = variety;
        this.style = style;
        this.type = type;
        this.producent = producent;
        this.region = region;
        this.year = year;
    }

    public WineArchive() {
    }

    public Long getIdWine() {
        return idWine;
    }

    public void setIdWine(Long idWine) {
        this.idWine = idWine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

}
