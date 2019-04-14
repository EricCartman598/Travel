/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190226.City.Domain;

import main.java.travel_20190226.Common.Business.Domain.BaseDomain;

/**
 * @author Виталий
 */
public class City extends BaseDomain {

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

    public City(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        super.id = id;
    }

    public City(Long id, String name, int population, boolean isCapital) {
        super(id);
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
}
