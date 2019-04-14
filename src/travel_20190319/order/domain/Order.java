/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190319.order.domain;

import main.java.travel_20190319.common.business.domain.BaseDomain;
import main.java.travel_20190319.country.domain.BaseCountry;
import main.java.travel_20190319.user.domain.User;


import java.util.List;

/**
 *
 * @author Виталий
 */
public class Order extends BaseDomain<Long> {
    private User user;
    private double price;
    private List<BaseCountry> countries;


    public Order(User user, double price, List<BaseCountry> countries) {
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

    public List<BaseCountry> getCountries() {
        return countries;
    }

    public void setCountries(List<BaseCountry> countries) {
        this.countries = countries;
    }    
}
