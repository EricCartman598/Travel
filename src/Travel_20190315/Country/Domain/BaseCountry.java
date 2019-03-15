/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190315.Country.Domain;


import Travel_20190315.City.Domain.City;
import Travel_20190315.Common.Business.Domain.BaseDomain;

import java.util.List;
import java.util.Objects;

/**
 * @author Виталий
 */
public class BaseCountry extends BaseDomain<Long> {

    private String name;
    private String language;
    private List<City> cities;
    CountryTemperatureType discriminator;

    public BaseCountry(String name) {
        this.name = name;
        this.language = null;
        this.cities = null;
    }

    public BaseCountry(String name, String language) {
        super();
        this.name = name;
        this.language = language;
        this.cities = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCountry country = (BaseCountry) o;
        return name.equals(country.name);/* &&
                language.equals(country.language) &&
                cities.equals(country.cities);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, cities);
    }
}
