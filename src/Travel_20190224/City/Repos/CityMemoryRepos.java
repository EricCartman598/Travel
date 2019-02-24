/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190224.City.Repos;

import Travel_20190224.City.City;

import static Travel_20190224.Storage.Storage.cities;


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

    public City findCityByName(String name) {

        for(City city : cities)
            if(city.getName().equals(name)) return city;

        return null;
    }
    
    public void deleteCityById(long id) {
        cities.remove(id);
    }
}
