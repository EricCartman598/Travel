package Travel_20190228.City.Service;

import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.City.Domain.City;

public interface CityService extends BaseService {

    void addCity(City city);

    City findCityById(Long id);

    City findCityByName(String name);
}
