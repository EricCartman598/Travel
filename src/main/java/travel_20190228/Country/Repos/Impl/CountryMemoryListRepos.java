/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190228.Country.Repos.Impl;

import main.java.travel_20190228.Country.Domain.Country;
import main.java.travel_20190228.Country.Repos.CountryRepos;
import main.java.travel_20190228.Country.Search.CountrySearchCondition;

import java.util.List;

import static main.java.travel_20190228.Storage.Storage.countries;


/**
 *
 * @author Виталий
 */
public class CountryMemoryListRepos implements CountryRepos {

    private static long sequence = 0;

    @Override
    public void addCountry(Country country) {
        country.setId(generateSequence());
        countries.add(country);        
    }

    @Override
    public Country findCountryById(long id) {
        for (Country country : countries) {
            if (country.getId().equals(id))
                return country;
        }
                
        return null;        
    }

    @Override
    public List<Country> findCountryByCondition(CountrySearchCondition countrySearchCondition) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        countries.remove(findCountryById(id));
    }

    @Override
    public void printAll() {
        for(Country country : countries)
            System.out.println(country.getName());
    }

    @Override
    public void update() {
        countries = countries;
    }

    @Override
    public long generateSequence() {
        return ++sequence;
    }
}
