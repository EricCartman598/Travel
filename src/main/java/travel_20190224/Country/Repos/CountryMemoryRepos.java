/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190224.Country.Repos;

import Travel_20190224.Country.Country;

import static Travel_20190224.Storage.Storage.countries;


/**
 *
 * @author Виталий
 */
public class CountryMemoryRepos {
    
    public void addCountry(Country country) {
        countries.add(country);        
    }
    
    public Country findCountryById(Long id) {
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getId().equals(id))
                return countries.get(i);
        }
                
        return null;        
    }
    
    public void deleteCountryById(long id) {
        countries.remove(id);
    }    
}
