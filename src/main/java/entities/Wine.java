package entities;

import java.time.LocalDate;

public class Wine {
    private int idWine;
    private String name;
    private String variety;
    private String style;
    private String type;
    private int idProducent;
    private int idRegion;
    private LocalDate year;

    public Wine(int idWine, String name, String variety, String style, String type, int idProducent, int idRegion, LocalDate year) {
        this.idWine = idWine;
        this.name = name;
        this.variety = variety;
        this.style = style;
        this.type = type;
        this.idProducent = idProducent;
        this.idRegion = idRegion;
        this.year = year;
    }

    public int getIdWine() {
        return idWine;
    }

    public void setIdWine(int idWine) {
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

    public int getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(int idProducent) {
        this.idProducent = idProducent;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
