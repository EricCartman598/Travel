/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190313.Country.Service.Impl;



import Travel_20190313.City.Domain.City;
import Travel_20190313.City.Repo.CityRepo;
import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Country.Repo.CountryRepo;
import Travel_20190313.Country.Search.CountrySearchCondition;
import Travel_20190313.Country.Service.CountryService;

import java.util.List;

import static Travel_20190313.Storage.Storage.cities;
import static Travel_20190313.Storage.Storage.countries;


/**
 * @author Виталий
 */
public class CountryMemoryListService implements CountryService {

    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;

    public CountryMemoryListService(CountryRepo countryRepo,
                                    CityRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    @Override
    public void deleteCityFromCountry(Country targetCountry, City targetCity) {
        countryRepo.deleteCityFromCountry(targetCountry, targetCity);
    }


    public Country findByName(String name) {
        return null;
    }

    @Override
    public List<Country> findByCondition(CountrySearchCondition searchCondition) {
        return countryRepo.findByCondition(searchCondition);
    }

    @Override
    public City getCapital(Country country) {
        for(City city : country.getCities()) {
            if(city.isCapital()) return city;
        }

        return null;
    }

    @Override
    public void add(Country data) {
        if(data == null)
            return;

        if(countries.contains(data))
            return;

        countryRepo.add(data);

        for (City city : data.getCities()) {
            if(!cities.contains(city))
                cityRepo.add(city);
        }
    }

    @Override
    public Country findById(Long id) {
        if(id != null)
            return countryRepo.findById(id);

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            countryRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        countryRepo.printAll();
    }

    @Override
    public void update(Country data) {
        countryRepo.update(data);
    }
}
