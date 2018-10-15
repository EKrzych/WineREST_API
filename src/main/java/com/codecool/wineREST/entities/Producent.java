package com.codecool.wineREST.entities;

public class Producent {
    private int idProducent;
    private String name;

    public Producent(int idProducent, String name) {
        this.idProducent = idProducent;
        this.name = name;
    }

    public int getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(int idProducent) {
        this.idProducent = idProducent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
