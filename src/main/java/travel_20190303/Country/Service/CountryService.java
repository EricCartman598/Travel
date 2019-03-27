package Travel_20190303.Country.Service;

import Travel_20190303.City.Domain.City;
import Travel_20190303.Common.Business.Service.BaseService;
import Travel_20190303.Country.Domain.Country;
import Travel_20190303.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {

    void addCountry(Country country);

    Country findCountryById(Long id);

    City getCapital(Country country);

    List<Country> findCountryByCondition(CountrySearchCondition countrySearchCondition);
}
