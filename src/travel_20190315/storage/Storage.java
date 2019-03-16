/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190315.storage;

import travel_20190315.country.domain.BaseCountry;
import travel_20190315.order.domain.Order;
import travel_20190315.user.domain.User;
import travel_20190315.city.domain.City;

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
