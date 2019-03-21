package travel_20190319.city.service;

import travel_20190319.city.domain.City;
import travel_20190319.city.search.CitySearchCondition;
import travel_20190319.common.business.exceptions.NeedToCancelOrderException;
import travel_20190319.common.solution.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);

    void deleteByEntity(City city) throws NeedToCancelOrderException;
}
