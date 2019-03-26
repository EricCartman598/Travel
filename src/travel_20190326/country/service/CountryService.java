package travel_20190326.country.service;

import travel_20190326.city.domain.City;
import travel_20190326.common.solution.service.BaseService;
import travel_20190326.country.domain.BaseCountry;
import travel_20190326.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    City getCapital(BaseCountry country);

    //void deleteCityFromCountry(Country targetCountry, city targetCity);

}
