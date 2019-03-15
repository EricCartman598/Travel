package Travel_20190315.City.Repo;

import Travel_20190315.City.Domain.City;
import Travel_20190315.City.Search.CitySearchCondition;
import Travel_20190315.Common.Solution.Repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);
}
