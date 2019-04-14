/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190224.City.Service;

import main.java.travel_20190224.City.City;
import main.java.travel_20190224.City.Repos.CityMemoryRepos;


/**
 *
 * @author Виталий
 */
public class CityMemoryService {

    private CityMemoryRepos cityRepos = new CityMemoryRepos();
    
    public void addCity(City city) {
        cityRepos.addCity(city);
    }
    
    public City findCityById(Long id) {
        return cityRepos.findCityById(id);
    }

    public City findCityByName(String name) {
        return cityRepos.findCityByName(name);
    }
    
    public void deleteCityById(long id) {
        cityRepos.deleteCityById(id);
    }
    
}
