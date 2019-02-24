/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190222.Country.Service;

import Travel_20190222.City.City;
import Travel_20190222.City.Repos.CityMemoryRepos;
import Travel_20190222.Country.Country;
import Travel_20190222.Country.Repos.CountryMemoryRepos;


/**
 *
 * @author Виталий
 */
public class CountryMemoryService {
    
    private CountryMemoryRepos countryRepos = new CountryMemoryRepos();
    private CityMemoryRepos cityRepos = new CityMemoryRepos();
    
    public void addCountry(Country country) {
        countryRepos.addCountry(country);

        for(City city : country.getCities())
            cityRepos.addCity(city);
    }
    
    public Country findCountryById(Long id) {
        return countryRepos.findCountryById(id);
    }
    
    public void deleteCountryById(long id) {
        countryRepos.deleteCountryById(id);
    }

}
