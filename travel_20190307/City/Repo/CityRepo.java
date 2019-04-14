package main.java.travel_20190307.City.Repo;

import main.java.travel_20190307.City.Domain.City;
import main.java.travel_20190307.City.Search.CitySearchCondition;
import main.java.travel_20190307.Common.Solution.Repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);
}
