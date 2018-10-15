package entities;

public class Region {
    private int idRegion;
    private  String name;
    private String country;

    public Region(int idRegion, String name, String country) {
        this.idRegion = idRegion;
        this.name = name;
        this.country = country;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
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
