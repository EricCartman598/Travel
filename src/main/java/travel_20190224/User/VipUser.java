package main.java.travel_20190224.User;

import main.java.travel_20190224.Order.Order;

import java.util.List;

public class VipUser extends User {

    private final boolean allIncluded = true;

    public VipUser(String serial, String number, Passport passport) {
        super(serial, number, passport);
    }

    public VipUser(String firstName, String lastName, Passport passport, List<Order> orders) {
        super(firstName, lastName, passport, orders);
    }

    public boolean isAllIncluded() {
        return allIncluded;
    }
}
