/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190315.country.repo.impl;


import travel_20190315.country.domain.BaseCountry;
import travel_20190315.country.repo.CountryRepo;
import travel_20190315.country.search.CountrySearchCondition;
import travel_20190315.storage.SequenceGenerator;

import java.util.List;

import static travel_20190315.storage.Storage.countries;

/**
 *
 * @author Виталий
 */
public class CountryMemoryListRepo implements CountryRepo {

    @Override
    public BaseCountry findByName(String name) {
        for(BaseCountry country : countries)
            if(country.getName().equals(name)) return country;

        return null;
    }

    @Override
    public List<BaseCountry> findByCondition(CountrySearchCondition searchCondition) {
        return null;
    }

    /*@Override
    public void deleteCityFromCountry(BaseCountry targetCountry, city targetCity) {
        targetCountry.getCities().remove(targetCity);
    }*/

    @Override
    public void add(BaseCountry data) {
        data.setId(SequenceGenerator.generateSequence());
        countries.add(data);
    }

    @Override
    public BaseCountry findById(Long id) {
        for (BaseCountry country : countries) {
            if (country.getId().equals(id))
                return country;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        countries.remove(findById(id));
    }

    @Override
    public void printAll() {
        for(BaseCountry country : countries)
            System.out.println("countryName: " + country.getName());
    }

    @Override
    public void update(BaseCountry data) {

    }
}
