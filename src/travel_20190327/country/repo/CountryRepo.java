package travel_20190327.country.repo;

import travel_20190327.common.solution.repo.BaseRepo;
import travel_20190327.country.domain.BaseCountry;
import travel_20190327.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    //void deleteCityFromCountry(Country targetCountry, city targetCity);
}
