package main.java.travel_20190228.User.Domain;

import main.java.travel_20190228.Order.Domain.Order;

import java.util.List;

public class SimpleUser extends User {

    public SimpleUser(String firstName, String lastName, Passport passport) {
        super(firstName, lastName, passport);
        allIncluded = false;
        userType = UserType.SIMPLE_USER;
    }

    public SimpleUser(String firstName, String lastName, Passport passport, List<Order> orders) {
        super(firstName, lastName, passport, orders);
        allIncluded = false;
        userType = UserType.SIMPLE_USER;
    }

    public UserType getUserType() {
        return userType;
    }
}
