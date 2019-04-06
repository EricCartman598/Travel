/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190406.storage;

import travel_20190406.city.domain.City;
import travel_20190406.country.domain.BaseCountry;
import travel_20190406.order.domain.Order;
import travel_20190406.user.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Виталий
 */
public class Storage {
    public static List<BaseCountry> countries = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
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
