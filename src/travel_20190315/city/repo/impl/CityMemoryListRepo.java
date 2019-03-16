package travel_20190315.city.repo.impl;

import travel_20190315.city.domain.City;
import travel_20190315.city.repo.CityRepo;
import travel_20190315.city.search.CitySearchCondition;
import travel_20190315.storage.SequenceGenerator;

import java.util.List;

import static travel_20190315.storage.Storage.cities;

public class CityMemoryListRepo implements CityRepo {


    @Override
    public City findByName(String name) {
        for(City city : cities)
            if(city.getName().equals(name)) return city;

        return null;
    }

    @Override
    public List<City> findByCondition(CitySearchCondition citySearchCondition) {
        return null;
    }

    @Override
    public void add(City data) {
        data.setId(SequenceGenerator.generateSequence());
        cities.add(data);
    }

    @Override
    public City findById(Long id) {
        for (City city : cities) {
            if (city.getId().equals(id))
                return city;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        cities.remove(findById(id));
    }

    @Override
    public void printAll() {
        for(City city : cities)
            System.out.println(city.getName());
    }

    @Override
    public void update(City data) {

    }
}

