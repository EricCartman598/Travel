/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190315.Order.Domain;

import Travel_20190315.Common.Business.Domain.BaseDomain;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.User.Domain.User;


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
