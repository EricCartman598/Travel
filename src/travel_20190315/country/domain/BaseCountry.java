/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190315.country.domain;


import travel_20190315.city.domain.City;
import travel_20190315.common.business.domain.BaseDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Виталий
 */
public class BaseCountry extends BaseDomain<Long> {

    protected String name;
    protected String language;
    protected List<City> cities = new ArrayList<>();
    protected CountryTemperatureType discriminator;

    public BaseCountry() {

    }

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

    public CountryTemperatureType getDiscriminator() {
        return discriminator;
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

    public void setDiscriminator(CountryTemperatureType discriminator) {
        this.discriminator = discriminator;
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
