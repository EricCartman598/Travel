package main.java.travel_20190307.Country.Service;

import main.java.travel_20190307.City.Domain.City;
import main.java.travel_20190307.Common.Solution.Service.BaseService;
import main.java.travel_20190307.Country.Domain.Country;
import main.java.travel_20190307.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {

    Country findByName(String name);

    List<Country> findByCondition(CountrySearchCondition searchCondition);

    City getCapital(Country country);

}
