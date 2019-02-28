/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190228.Country.Service.Impl;

import Travel_20190228.City.Domain.City;
import Travel_20190228.City.Repos.CityRepos;
import Travel_20190228.City.Repos.Impl.CityMemoryListRepos;
import Travel_20190228.Country.Domain.Country;
import Travel_20190228.Country.Repos.CountryRepos;
import Travel_20190228.Country.Repos.Impl.CountryMemoryListRepos;
import Travel_20190228.Country.Service.CountryService;


/**
 * @author Виталий
 */
public class CountryMemoryListService implements CountryService {

    private CountryRepos countryRepos = new CountryMemoryListRepos();
    private CityRepos cityRepos = new CityMemoryListRepos();

    @Override
    public void addCountry(Country country) {
        countryRepos.addCountry(country);

        for (City city : country.getCities())
            cityRepos.addCity(city);
    }

    @Override
    public Country findCountryById(Long id) {
        if(id != null)
            return countryRepos.findCountryById(id);

        return null;
    }

    @Override
    public City getCapital(Country country) {
        for(City city : country.getCities()) {
            if(city.isCapital()) return city;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            countryRepos.deleteById(id);

    }

    @Override
    public void printAll() {

    }
}
