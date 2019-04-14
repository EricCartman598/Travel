/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190322.storage;

import main.java.travel_20190322.country.domain.BaseCountry;
import main.java.travel_20190322.order.domain.Order;
import main.java.travel_20190322.user.domain.User;
import main.java.travel_20190322.city.domain.City;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
