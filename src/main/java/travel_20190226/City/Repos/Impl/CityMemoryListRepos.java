package main.java.travel_20190226.City.Repos.Impl;

import main.java.travel_20190226.City.Domain.City;
import main.java.travel_20190226.City.Repos.CityRepos;

import static main.java.travel_20190226.Storage.Storage.cities;

public class CityMemoryListRepos implements CityRepos {

    @Override
    public void addCity(City city) {
        cities.add(city);
    }

    @Override
    public City findCityById(long id) {
        for (City city : cities) {
            if (city.getId().equals(id))
                return city;
        }

        return null;
    }

    @Override
    public City findCityByName(String name) {
        for(City city : cities)
            if(city.getName().equals(name)) return city;

        return null;
    }

    @Override
    public void deleteById(long id) {
        cities.remove(id);
    }

    @Override
    public void printAll() {
        for(City city : cities)
            System.out.println(city.getName());
    }
}
