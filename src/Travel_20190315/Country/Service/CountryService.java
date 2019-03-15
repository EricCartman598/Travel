package Travel_20190315.Country.Service;

import Travel_20190315.City.Domain.City;
import Travel_20190315.Common.Solution.Service.BaseService;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    City getCapital(BaseCountry country);

    void deleteCityFromCountry(BaseCountry targetCountry, City targetCity);

}
