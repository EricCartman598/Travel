package travel_20190406.city.repo;

import travel_20190406.city.domain.City;
import travel_20190406.city.search.CitySearchCondition;
import travel_20190406.common.solution.repo.BaseRepo;

import java.util.List;
import java.util.function.Predicate;

public interface CityRepo extends BaseRepo<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);

    <P> City findByParam(Predicate<City> param, P targetParam);
}
