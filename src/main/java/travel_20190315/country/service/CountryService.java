package main.java.travel_20190315.country.service;

import main.java.travel_20190315.city.domain.City;
import main.java.travel_20190315.common.solution.service.BaseService;
import main.java.travel_20190315.country.domain.BaseCountry;
import main.java.travel_20190315.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    City getCapital(BaseCountry country);

    //void deleteCityFromCountry(Country targetCountry, city targetCity);

}
