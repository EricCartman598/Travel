package Travel_20190315.City.Service;

import Travel_20190315.City.Domain.City;
import Travel_20190315.City.Search.CitySearchCondition;
import Travel_20190315.Common.Business.Exceptions.NeedToCancelOrderException;
import Travel_20190315.Common.Solution.Service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    City findByName(String name);

    List<City> findByCondition(CitySearchCondition searchCondition);

    void deleteByEntity(City city) throws NeedToCancelOrderException;
}
