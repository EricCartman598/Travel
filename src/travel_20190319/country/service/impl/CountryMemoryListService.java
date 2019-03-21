/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190319.country.service.impl;


import travel_20190319.city.domain.City;
import travel_20190319.city.repo.CityRepo;
import travel_20190319.country.domain.BaseCountry;
import travel_20190319.country.repo.CountryRepo;
import travel_20190319.country.search.CountrySearchCondition;
import travel_20190319.country.service.CountryService;

import java.util.List;

import static travel_20190319.storage.Storage.cities;
import static travel_20190319.storage.Storage.countries;


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

    /*
    @Override
    public void deleteCityFromCountry(BaseCountry targetCountry, city targetCity) {
        countryRepo.deleteCityFromCountry(targetCountry, targetCity);
    }
    */

    public BaseCountry findByName(String name) {
        if (!name.trim().isEmpty())
            return countryRepo.findByName(name);

        return null;
    }

    @Override
    public List<BaseCountry> findByCondition(CountrySearchCondition searchCondition) {
        return countryRepo.findByCondition(searchCondition);
    }

    @Override
    public City getCapital(BaseCountry country) {
        for (City city : country.getCities()) {
            if (city.isCapital()) return city;
        }

        return null;
    }

    @Override
    public void add(BaseCountry data) {
        if (data == null)
            return;

        if (countries.contains(data))
            return;

        countryRepo.add(data);

        for (City city : data.getCities()) {
            if (!cities.contains(city))
                cityRepo.add(city);
        }
    }

    @Override
    public BaseCountry findById(Long id) {
        if (id != null)
            return countryRepo.findById(id);

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (id != null)
            countryRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        countryRepo.printAll();
    }

    @Override
    public void update(BaseCountry data) {
        countryRepo.update(data);
    }
}
