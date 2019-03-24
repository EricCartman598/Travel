/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190322.storage;

import travel_20190322.country.domain.BaseCountry;
import travel_20190322.order.domain.Order;
import travel_20190322.user.domain.User;
import travel_20190322.city.domain.City;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Виталий
 */
@XmlRootElement(name = "countries")
public class Storage {
    public static List<BaseCountry> countries = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    public static List<BaseCountry> getCountries() {
        return countries;
    }

    @XmlElement(name = "country")
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
