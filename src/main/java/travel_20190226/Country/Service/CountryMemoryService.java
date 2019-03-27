/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190226.Country.Service;

import Travel_20190226.City.Domain.City;
import Travel_20190226.City.Repos.CityRepos;
import Travel_20190226.City.Repos.Impl.CityMemoryListRepos;
import Travel_20190226.Country.Country;
import Travel_20190226.Country.Repos.CountryMemoryRepos;


/**
 * @author Виталий
 */
public class CountryMemoryService {

    private CountryMemoryRepos countryRepos = new CountryMemoryRepos();
    private CityRepos cityRepos = new CityMemoryListRepos();

    public void addCountry(Country country) {
        countryRepos.addCountry(country);

        for (City city : country.getCities())
            cityRepos.addCity(city);
    }

    public Country findCountryById(Long id) {
        return countryRepos.findCountryById(id);
    }

    public void deleteCountryById(long id) {
        countryRepos.deleteCountryById(id);
    }

    public City getCapital(Country country) {
        for(City city : country.getCities()) {
            if(city.isCapital()) return city;
        }

        return null;
    }
}
