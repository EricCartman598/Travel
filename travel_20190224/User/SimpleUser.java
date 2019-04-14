package main.java.travel_20190224.User;

import main.java.travel_20190224.Order.Order;
import main.java.travel_20190224.User.User;

import java.util.List;

public class SimpleUser extends User {

    private final boolean allIncluded = false;

    public SimpleUser(String serial, String number, Passport passport) {
        super(serial, number, passport);
    }

    public SimpleUser(String firstName, String lastName, Passport passport, List<Order> orders) {
        super(firstName, lastName, passport, orders);
    }

    public boolean isAllIncluded() {
        return allIncluded;
    }
}
