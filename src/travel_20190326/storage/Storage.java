/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190326.storage;

import travel_20190326.city.domain.City;
import travel_20190326.country.domain.BaseCountry;
import travel_20190326.order.domain.Order;
import travel_20190326.user.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Виталий
 */
//@XmlRootElement(name = "countries")
public class Storage {
    //@XmlElement(name = "country")
    public static List<BaseCountry> countries = new ArrayList<>();
    //@XmlTransient
    public static List<City> cities = new ArrayList<>();
    //@XmlTransient
    public static List<Order> orders = new ArrayList<>();
    //@XmlTransient
    public static List<User> users = new ArrayList<>();

    public static List<BaseCountry> getCountries() {
        return countries;
    }


    public static void setCountries(List<BaseCountry> countries) {
        Storage.countries = countries;
    }

    public static List<City> getCities() {
        return cities;
    }

    public static void setCities(List<City> cities) {
        Storage.cities = cities;
    }
}
