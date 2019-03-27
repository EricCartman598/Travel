package main.java.travel_20190313.Country.Repo;

import main.java.travel_20190313.City.Domain.City;
import main.java.travel_20190313.Common.Solution.Repo.BaseRepo;
import main.java.travel_20190313.Country.Domain.Country;
import main.java.travel_20190313.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<Country, Long> {

    Country findByName(String name);

    List<Country> findByCondition(CountrySearchCondition searchCondition);

    void deleteCityFromCountry(Country targetCountry, City targetCity);
}
