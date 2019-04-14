/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190319.storage;

import main.java.travel_20190319.country.domain.BaseCountry;
import main.java.travel_20190319.order.domain.Order;
import main.java.travel_20190319.user.domain.User;
import main.java.travel_20190319.city.domain.City;

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


}
