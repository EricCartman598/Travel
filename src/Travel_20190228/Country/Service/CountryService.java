package Travel_20190228.Country.Service;

import Travel_20190228.City.Domain.City;
import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.Country.Domain.Country;

public interface CountryService extends BaseService {

    void addCountry(Country country);

    Country findCountryById(Long id);

    City getCapital(Country country);
}
