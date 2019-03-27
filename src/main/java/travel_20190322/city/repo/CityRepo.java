package main.java.travel_20190322.city.repo;

import main.java.travel_20190322.city.domain.City;
import main.java.travel_20190322.city.search.CitySearchCondition;
import main.java.travel_20190322.common.solution.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);
}
