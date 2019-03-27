package Travel_20190226.City.Service;

import Travel_20190226.City.Domain.City;
import Travel_20190226.City.Repos.CityRepos;
import Travel_20190226.Common.Business.Service.BaseService;

public interface CityService extends BaseService {

    void addCity(City city);

    City findCityById(Long id);

    City findCityByName(String name);
}
