package Travel_20190307.City.Service;

import Travel_20190307.City.Domain.City;
import Travel_20190307.City.Search.CitySearchCondition;
import Travel_20190307.Common.Solution.Service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);
}
