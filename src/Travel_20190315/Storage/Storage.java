/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190315.Storage;

import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Country.Domain.ColdCountry;
import Travel_20190315.Country.Domain.HotCountry;
import Travel_20190315.Order.Domain.Order;
import Travel_20190315.User.Domain.User;
import Travel_20190315.City.Domain.City;

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
