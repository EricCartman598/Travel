package travel_20190406.city.service;

import travel_20190406.city.domain.City;
import travel_20190406.city.search.CitySearchCondition;
import travel_20190406.common.business.exceptions.CannotDeleteCityException;
import travel_20190406.common.business.exceptions.NeedToCancelOrderException;
import travel_20190406.common.solution.service.BaseService;

import java.util.List;
import java.util.function.Predicate;

public interface CityService extends BaseService<City, Long> {

    City findByName(String name);

    <P> City findByParam(Predicate<City> param, P targetParam);

    List<City> findByCondition(CitySearchCondition searchCondition);

    void deleteByEntity(City city) throws CannotDeleteCityException;    //throws NeedToCancelOrderException;
}
