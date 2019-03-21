package travel_20190319.country.repo;

import travel_20190319.common.solution.repo.BaseRepo;
import travel_20190319.country.domain.BaseCountry;
import travel_20190319.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    //void deleteCityFromCountry(BaseCountry targetCountry, city targetCity);
}
