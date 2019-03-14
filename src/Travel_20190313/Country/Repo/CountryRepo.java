package Travel_20190313.Country.Repo;

import Travel_20190313.City.Domain.City;
import Travel_20190313.Common.Solution.Repo.BaseRepo;
import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<Country, Long> {

    Country findByName(String name);

    List<Country> findByCondition(CountrySearchCondition searchCondition);

    void deleteCityFromCountry(Country targetCountry, City targetCity);
}
