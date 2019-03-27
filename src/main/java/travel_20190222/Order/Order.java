/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190222.Order;

import Travel_20190222.Country.Country;
import Travel_20190222.User.User;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class Order {
    private Long id;
    private User user;    
    private double price;
    private List<Country> countries;

    public Order(User user, double price, List<Country> countries) {
        this.user = user;
        this.price = price;
        this.countries = countries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
