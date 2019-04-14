/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190226.Country;



import main.java.travel_20190226.City.Domain.City;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class Country {
    private Long id;
    private String name;
    private String language;
    private List<City> cities;

    public Country(String name, String language) {
        this.name = name;
        this.language = language;        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
