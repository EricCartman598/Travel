package main.java.travel_20190226.User;

import main.java.travel_20190226.Order.Order;

import java.util.List;

public class VipUser extends User {

    private final boolean allIncluded = true;
    private final boolean hasTransfer = true;
    private UserBonus bonus;

    public VipUser(String serial, String number, Passport passport, UserBonus bonus) {
        super(serial, number, passport);
        this.bonus = bonus;
    }

    public VipUser(String firstName, String lastName, Passport passport, List<Order> orders, UserBonus bonus) {
        super(firstName, lastName, passport, orders);
        this.bonus = bonus;
    }

    public boolean isAllIncluded() {
        return allIncluded;
    }
}
