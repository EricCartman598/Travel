package travel_20190406.city.repo.impl;

import travel_20190406.city.domain.City;
import travel_20190406.city.repo.CityRepo;
import travel_20190406.city.search.CitySearchCondition;
import travel_20190406.common.solution.search.Paginator;
import travel_20190406.storage.SequenceGenerator;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static travel_20190406.storage.Storage.cities;

public class CityMemoryListRepo implements CityRepo {


    @Override
    public City findByName(String name) {
        for (City city : cities) {
            if (city.getName().equals(name))
                return city;
        }
        return null;
    }


    @Override
    public List<City> findByCondition(CitySearchCondition citySearchCondition) {
        return null;
    }


    @Override
    public <P> City findByParam(Predicate<City> param, P targetParam) {
        for (City city : cities) {
            if(param.test(city))
                return city;
        }
        return null;
    }

    @Override
    public void add(City data) {
        data.setId(SequenceGenerator.generateSequence());
        cities.add(data);
    }

    @Override
    public City findById(Long id) {
        return (cities.stream().filter(city -> city.getId().equals(id)).collect(Collectors.toList())).get(0);
        /*for (City city : cities) {
            if (city.getId().equals(id))
                return city;
        }

        return null;*/
    }

    @Override
    public void deleteById(Long id) {
        cities.remove(findById(id));
    }

    @Override
    public void printAll(Paginator paginator) {
        cities.stream().spliterator().forEachRemaining(city -> System.out.println(city.getName()));
        //for (City city : cities)
        //    System.out.println(city.getName());
    }

    @Override
    public void update(City data) {

    }
}

