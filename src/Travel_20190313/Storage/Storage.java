/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190313.Storage;

import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Order.Domain.Order;
import Travel_20190313.User.Domain.User;
import Travel_20190313.City.Domain.City;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Виталий
 */
public class Storage {
    public static List<Country> countries = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<User> users = new ArrayList<>();


}
