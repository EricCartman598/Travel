/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190322.country.domain;


import travel_20190322.city.domain.City;
import travel_20190322.common.business.domain.BaseDomain;
import travel_20190322.country.domain.CountryTemperatureType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;

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
        //this.cities = null;
    }

    public BaseCountry(String name, String language) {
        super();
        this.name = name;
        this.language = language;
        //this.cities = null;
    }

    public BaseCountry(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public CountryTemperatureType getDiscriminator() {
        return discriminator;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "country_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    @XmlElement(name = "language")
    public void setLanguage(String language) {
        this.language = language;
    }

    public List<City> getCities() {
        return cities;
    }

    @XmlElementWrapper(name = "cities")
    @XmlElement(name = "city")
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @XmlAttribute
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
