package main.java.travel_20190322.city.service;

import main.java.travel_20190322.city.domain.City;
import main.java.travel_20190322.city.search.CitySearchCondition;
import main.java.travel_20190322.common.business.exceptions.CannotDeleteCityException;
import main.java.travel_20190322.common.business.exceptions.NeedToCancelOrderException;
import main.java.travel_20190322.common.solution.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);

    void deleteByEntity(City city) throws CannotDeleteCityException;    //throws NeedToCancelOrderException;
}
