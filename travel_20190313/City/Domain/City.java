/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190313.City.Domain;

import main.java.travel_20190313.Common.Business.Domain.BaseDomain;

import java.util.Objects;

/**
 * @author Виталий
 */
public class City extends BaseDomain<Long> {

    private String name;
    private int population;
    private boolean isCapital;
    Climate climate;

    public enum Climate {
        TROPIC,
        SUB_TROPIC,
        CONTINENTAL,
        ARCTIC,
        OTHER
    }

    public City(String name) {
        super();
        this.name = name;
    }

    public City(String name, int population, boolean isCapital) {
        super();
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
