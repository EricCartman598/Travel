package main.java.travel_20190226.City.Service;

import main.java.travel_20190226.City.Domain.City;
import main.java.travel_20190226.City.Repos.CityRepos;
import main.java.travel_20190226.Common.Business.Service.BaseService;

public interface CityService extends BaseService {

    void addCity(City city);

    City findCityById(Long id);

    City findCityByName(String name);
}
