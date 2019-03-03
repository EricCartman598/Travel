/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190303.Country.Service.Impl;


import Travel_20190303.City.Domain.City;
import Travel_20190303.City.Repos.CityRepos;
import Travel_20190303.City.Repos.Impl.CityMemoryListRepos;
import Travel_20190303.Country.Domain.Country;
import Travel_20190303.Country.Repos.CountryRepos;
import Travel_20190303.Country.Repos.Impl.CountryMemoryListRepos;
import Travel_20190303.Country.Search.CountrySearchCondition;
import Travel_20190303.Country.Service.CountryService;
import Travel_20190303.Storage.Storage;

import java.util.List;

import static Travel_20190303.Storage.Storage.cities;
import static Travel_20190303.Storage.Storage.countries;


/**
 * @author Виталий
 */
public class CountryMemoryListService implements CountryService {

    private final CountryRepos countryRepos;
    private final CityRepos cityRepos;

    public CountryMemoryListService(CountryRepos countryRepos, CityRepos cityRepos) {
        this.countryRepos = countryRepos;
        this.cityRepos = cityRepos;
    }

    @Override
    public void addCountry(Country country) {
        if(country == null)
            return;

        if(countries.contains(country))
            return;

        countryRepos.addCountry(country);

        for (City city : country.getCities()) {
            if(!cities.contains(city))
                cityRepos.addCity(city);
        }

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
    public List<Country> findCountryByCondition(CountrySearchCondition countrySearchCondition) {
        return countryRepos.findCountryByCondition(countrySearchCondition);
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            countryRepos.deleteById(id);

    }

    @Override
    public void printAll() {
        countryRepos.printAll();
    }

    @Override
    public void update() {
        countryRepos.update();
    }
}
