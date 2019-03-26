/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190326.country.repo.impl;


import travel_20190326.common.solution.search.Paginator;
import travel_20190326.country.domain.BaseCountry;
import travel_20190326.country.domain.ColdCountry;
import travel_20190326.country.domain.HotCountry;
import travel_20190326.country.repo.CountryRepo;
import travel_20190326.country.search.CountrySearchCondition;
import travel_20190326.storage.SequenceGenerator;

import java.util.List;

import static travel_20190326.country.domain.CountryTemperatureType.COLD;
import static travel_20190326.storage.Storage.countries;

/**
 *
 * @author Виталий
 */
public class CountryMemoryListRepo implements CountryRepo {

    @Override
    public BaseCountry findByName(String name) {
        for(BaseCountry country : countries) {
            if (country.getName().equals(name))
                return country;
        }
        return null;
    }

    @Override
    public List<BaseCountry> findByCondition(CountrySearchCondition searchCondition) {
        return null;
    }

    /*@Override
    public void deleteCityFromCountry(Country targetCountry, city targetCity) {
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
    public void printAll(Paginator paginator) {
        for(BaseCountry country : countries) {
            System.out.println("countryName: " + country.getName());
            switch(country.getDiscriminator()) {
                case COLD:
                    System.out.println("This is cold country");
                    System.out.println("telephone code: " + ((ColdCountry)country).getTelephoneCode());
                    System.out.println("is polar night : " + ((ColdCountry)country).isPolarNight());
                    break;
                case HOT:
                    System.out.println("This is hot country");
                    System.out.println("Average temperature: " + ((HotCountry)country).getAverageTemperature());
                    break;
            }
        }
    }

    @Override
    public void update(BaseCountry data) {

    }
}
