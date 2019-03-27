package Travel_20190303.City.Repos.Impl;

import Travel_20190303.City.Domain.City;
import Travel_20190303.City.Repos.CityRepos;
import Travel_20190303.City.Search.CitySearchCondition;

import java.util.List;

import static Travel_20190303.Storage.Storage.cities;
import static Travel_20190303.Storage.Storage.countries;

public class CityMemoryListRepos implements CityRepos {

    private static long sequence = 0;

    @Override
    public void addCity(City city) {
        city.setId(generateSequence());
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
    public List<City> findCityByCondition(CitySearchCondition citySearchCondition) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        countries.remove(findCityById(id));
    }

    @Override
    public void printAll() {
        for(City city : cities)
            System.out.println(city.getName());
    }

    @Override
    public void update() {
        cities = cities;
    }

    @Override
    public long generateSequence() {
        return ++sequence;
    }


}
