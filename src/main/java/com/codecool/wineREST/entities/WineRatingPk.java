package com.codecool.wineREST.entities;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class WineRatingPk implements Serializable {
    @ManyToOne
    private Wine wine;

    @Column(insertable = false, updatable = false, nullable = false)
    private String username;

    public WineRatingPk(Wine wine, String username) {
        this.wine = wine;
        this.username = username;
    }

    public WineRatingPk() {
    }

    public Wine getWine() {
        return wine;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WineRatingPk that = (WineRatingPk) o;
        return Objects.equals(wine, that.wine) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wine, username);
    }

    @Override
    public String toString() {
        return "WineRatingPk{" +
                "wineId=" + wine +
                ", username='" + username + '\'' +
                '}';
    }


}
