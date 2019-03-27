package Travel_20190228.City.Service;

import Travel_20190228.City.Search.CitySearchCondition;
import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.City.Domain.City;

import java.util.List;

public interface CityService extends BaseService {

    void addCity(City city);

    City findCityById(Long id);

    City findCityByName(String name);

    List<City> findCityByCondition(CitySearchCondition citySearchCondition);
}
