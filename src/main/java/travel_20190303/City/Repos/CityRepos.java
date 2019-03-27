/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190303.City.Repos;

import Travel_20190303.City.Search.CitySearchCondition;
import Travel_20190303.Common.Business.Repos.BaseRepos;
import Travel_20190303.City.Domain.City;

import java.util.List;


/**
 *
 * @author Виталий
 */
public interface CityRepos extends BaseRepos {
    
    void addCity(City city);

    City findCityById(long id);

    City findCityByName(String name);

    List<City> findCityByCondition(CitySearchCondition citySearchCondition);
}
