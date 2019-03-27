/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190222.City.Repos;

import main.java.travel_20190222.City.City;

import static main.java.travel_20190222.Storage.Storage.cities;


/**
 *
 * @author Виталий
 */
public class CityMemoryRepos {
    
    public void addCity(City city) {
        cities.add(city);
    }
    
    public City findCityById(Long id) {
        for(int i = 0; i < cities.size(); i++) {
            if(cities.get(i).getId().equals(id))
                return cities.get(i);
        }
                
        return null;        
    }
    
    public void deleteCityById(long id) {
        cities.remove(id);
    }
}
