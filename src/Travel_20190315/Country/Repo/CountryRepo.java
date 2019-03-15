package Travel_20190315.Country.Repo;

import Travel_20190315.City.Domain.City;
import Travel_20190315.Common.Solution.Repo.BaseRepo;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {

    BaseCountry findByName(String name);

    List<BaseCountry> findByCondition(CountrySearchCondition searchCondition);

    //void deleteCityFromCountry(BaseCountry targetCountry, City targetCity);
}
