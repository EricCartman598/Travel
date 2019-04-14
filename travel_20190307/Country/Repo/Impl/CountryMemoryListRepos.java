/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190307.Country.Repo.Impl;


import main.java.travel_20190307.Country.Domain.Country;
import main.java.travel_20190307.Country.Repo.CountryRepo;
import main.java.travel_20190307.Country.Search.CountrySearchCondition;
import main.java.travel_20190307.Storage.SequenceGenerator;

import java.util.List;

import static main.java.travel_20190307.Storage.Storage.countries;

/**
 *
 * @author Виталий
 */
public class CountryMemoryListRepos implements CountryRepo {

    @Override
    public Country findByName(String name) {
        for(Country country : countries)
            if(country.getName().equals(name)) return country;

        return null;
    }

    @Override
    public List<Country> findByCondition(CountrySearchCondition searchCondition) {
        return null;
    }

    @Override
    public void add(Country data) {
        data.setId(SequenceGenerator.generateSequence());
        countries.add(data);
    }

    @Override
    public Country findById(Long id) {
        for (Country country : countries) {
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
        for(Country country : countries)
            System.out.println("countryName: " + country.getName());
    }

    @Override
    public void update(Country data) {

    }
}
