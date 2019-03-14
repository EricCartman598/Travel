package Travel_20190313.City.Repo;

import Travel_20190313.City.Domain.City;
import Travel_20190313.City.Search.CitySearchCondition;
import Travel_20190313.Common.Solution.Repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);
}
