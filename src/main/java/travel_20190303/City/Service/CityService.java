package main.java.travel_20190303.City.Service;

import main.java.travel_20190303.Common.Business.Service.BaseService;
import main.java.travel_20190303.City.Domain.City;
import main.java.travel_20190303.City.Search.CitySearchCondition;


import java.util.List;

public interface CityService extends BaseService {

    void addCity(City city);

    City findCityById(Long id);

    City findCityByName(String name);

    List<City> findCityByCondition(CitySearchCondition citySearchCondition);
}
