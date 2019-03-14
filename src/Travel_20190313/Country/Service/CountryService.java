package Travel_20190313.Country.Service;

import Travel_20190313.City.Domain.City;
import Travel_20190313.Common.Solution.Service.BaseService;
import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {

    Country findByName(String name);

    List<Country> findByCondition(CountrySearchCondition searchCondition);

    City getCapital(Country country);

    void deleteCityFromCountry(Country targetCountry, City targetCity);

}
