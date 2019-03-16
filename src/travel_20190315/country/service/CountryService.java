package travel_20190315.country.service;

import travel_20190315.city.domain.City;
import travel_20190315.common.solution.service.BaseService;
import travel_20190315.country.domain.BaseCountry;
import travel_20190315.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    City getCapital(BaseCountry country);

    //void deleteCityFromCountry(BaseCountry targetCountry, city targetCity);

}
