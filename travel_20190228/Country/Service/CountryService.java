package main.java.travel_20190228.Country.Service;

import main.java.travel_20190228.City.Domain.City;
import main.java.travel_20190228.Common.Business.Service.BaseService;
import main.java.travel_20190228.Country.Domain.Country;
import main.java.travel_20190228.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {

    void addCountry(Country country);

    Country findCountryById(Long id);

    City getCapital(Country country);

    List<Country> findCountryByCondition(CountrySearchCondition countrySearchCondition);
}
