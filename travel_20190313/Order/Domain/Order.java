/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190313.Order.Domain;

import main.java.travel_20190313.Common.Business.Domain.BaseDomain;
import main.java.travel_20190313.Country.Domain.Country;
import main.java.travel_20190313.User.Domain.User;


import java.util.List;

/**
 *
 * @author Виталий
 */
public class Order extends BaseDomain<Long> {
    private User user;
    private double price;
    private List<Country> countries;



    public Order(User user, double price, List<Country> countries) {
        super();
        this.user = user;
        this.price = price;
        this.countries = countries;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }    
}
