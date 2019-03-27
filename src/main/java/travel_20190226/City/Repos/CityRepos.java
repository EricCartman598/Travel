/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190226.City.Repos;

import main.java.travel_20190226.City.Domain.City;
import main.java.travel_20190226.Common.Business.Repos.BaseRepos;


/**
 *
 * @author Виталий
 */
public interface CityRepos extends BaseRepos {
    
    void addCity(City city);

    City findCityById(long id);

    City findCityByName(String name);
}
