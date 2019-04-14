/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190226.City.Service.Impl;

import main.java.travel_20190226.City.Domain.City;
import main.java.travel_20190226.City.Repos.CityRepos;
import main.java.travel_20190226.City.Repos.Impl.CityMemoryListRepos;
import main.java.travel_20190226.City.Service.CityService;


/**
 *
 * @author Виталий
 */
public class CityMemoryListService implements CityService {

    private CityRepos cityRepos = new CityMemoryListRepos();

    @Override
    public void addCity(City city) {
        cityRepos.addCity(city);
    }

    @Override
    public City findCityById(Long id) {
        if(id != null)
            return cityRepos.findCityById(id);

        return null;
    }

    @Override
    public City findCityByName(String name) {
        if(!name.trim().isEmpty())
            return cityRepos.findCityByName(name);

        return null;
    }

    @Override
    public void deleteById(long id) {
        cityRepos.deleteById(id);
    }

    @Override
    public void printAll() {
        cityRepos.printAll();
    }

   /* private CityRepos cityRepos = new CityRepos();


    
    public void deleteCityById(Long id) {
        cityRepos.deleteById(id);
    }
    */
    
}
