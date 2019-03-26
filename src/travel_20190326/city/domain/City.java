/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190326.city.domain;

import travel_20190326.common.business.domain.BaseDomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * @author Виталий
 */

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "name", "population", "isCapital"})
public class City extends BaseDomain<Long> {

    //@XmlElement(name = "city_name")
    private String name;
    //@XmlElement(name = "population")
    private int population;
    //@XmlElement(name = "is_capital")
    private boolean isCapital;
    /*Climate climate;

    public enum Climate {
        TROPIC,
        SUB_TROPIC,
        CONTINENTAL,
        ARCTIC,
        OTHER
    }*/

    public City() {

    }

    public City(String name) {
        super();
        this.name = name;
    }

    public City(String name, int population, boolean isCapital) {
        super();
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

   // @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    //@XmlElement(name = "population")
    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    //@XmlElement(name = "isCapital")
    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
