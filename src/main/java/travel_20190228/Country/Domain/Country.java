/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190228.Country.Domain;



import main.java.travel_20190228.City.Domain.City;
import main.java.travel_20190228.Common.Business.Domain.BaseDomain;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Виталий
 */
public class Country extends BaseDomain {

    private String name;
    private String language;
    private List<City> cities;

    public Country(String name, String language) {
        super();
        this.name = name;
        this.language = language;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
