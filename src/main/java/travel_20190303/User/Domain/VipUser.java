package main.java.travel_20190303.User.Domain;



import main.java.travel_20190303.Order.Domain.Order;

import java.util.List;

public class VipUser extends User {

    private final boolean hasTransfer = true;
    private UserBonus bonus;


    public VipUser(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public VipUser(String firstName, String lastName, Passport passport, UserBonus bonus) {
        super(firstName, lastName, passport);
        this.bonus = bonus;
        allIncluded = true;
        userType = UserType.VIP_USER;
    }

    public VipUser(String firstName, String lastName, Passport passport, List<Order> orders, UserBonus bonus) {
        super(firstName, lastName, passport, orders);
        this.bonus = bonus;
        allIncluded = true;
        userType = UserType.VIP_USER;
    }

    public UserType getUserType() {
        return userType;
    }
}
