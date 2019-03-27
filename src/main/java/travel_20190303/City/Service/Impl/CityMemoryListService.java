/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190303.City.Service.Impl;

import main.java.travel_20190303.City.Domain.City;
import main.java.travel_20190303.City.Repos.CityRepos;
import main.java.travel_20190303.City.Repos.Impl.CityMemoryListRepos;
import main.java.travel_20190303.City.Search.CitySearchCondition;
import main.java.travel_20190303.City.Service.CityService;

import java.util.List;


/**
 *
 * @author Виталий
 */
public class CityMemoryListService implements CityService {

    private final CityRepos cityRepos;

    public CityMemoryListService(CityRepos cityRepos) {
        this.cityRepos = cityRepos;
    }

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
    public List<City> findCityByCondition(CitySearchCondition citySearchCondition) {
        return cityRepos.findCityByCondition(citySearchCondition);
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            cityRepos.deleteById(id);
    }

    @Override
    public void printAll() {
        cityRepos.printAll();
    }

    @Override
    public void update() {
        cityRepos.update();
    }


}
