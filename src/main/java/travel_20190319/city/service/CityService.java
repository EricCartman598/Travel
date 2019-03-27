package main.java.travel_20190319.city.service;

import main.java.travel_20190319.city.domain.City;
import main.java.travel_20190319.city.search.CitySearchCondition;
import main.java.travel_20190319.common.business.exceptions.NeedToCancelOrderException;
import main.java.travel_20190319.common.solution.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);

    void deleteByEntity(City city) throws NeedToCancelOrderException;
}
