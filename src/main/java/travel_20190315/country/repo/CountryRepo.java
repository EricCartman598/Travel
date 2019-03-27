package main.java.travel_20190315.country.repo;

import main.java.travel_20190315.common.solution.repo.BaseRepo;
import main.java.travel_20190315.country.domain.BaseCountry;
import main.java.travel_20190315.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    //void deleteCityFromCountry(Country targetCountry, city targetCity);
}
