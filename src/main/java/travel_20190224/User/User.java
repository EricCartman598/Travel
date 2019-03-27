/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190224.User;


import main.java.travel_20190224.Order.Order;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Passport passport;
    private List<Order> orders;

    public class Passport {
        private String serial;
        private String number;

        public Passport(String serial, String number) {
            this.serial = serial;
            this.number = number;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String firstName, String lastName, Passport passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }        
        
    public User(String firstName, String lastName, Passport passport, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.orders = orders;
    }

     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
   /*
    boolean makeOrder(List<main.java.travel_20190222.Country> countries) {
        return true;
    }

    boolean changeOrder(main.java.travel_20190222.order newOrder, main.java.travel_20190222.order oldOrder) {
        return true;
    }

    boolean cancelOrder(main.java.travel_20190222.order cancelledOrder) {
        return true;
    } */   
    
}
