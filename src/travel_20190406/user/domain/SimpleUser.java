package travel_20190406.user.domain;

import travel_20190406.order.domain.Order;
import travel_20190406.user.domain.User;
import travel_20190406.user.domain.UserType;

import java.util.List;

public class SimpleUser extends User {

    public SimpleUser(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public SimpleUser(String firstName, String lastName, Passport passport) {
        super(firstName, lastName, passport);
        allIncluded = false;
        userType = travel_20190406.user.domain.UserType.SIMPLE_USER;
    }

    public SimpleUser(String firstName, String lastName, Passport passport, List<Order> orders) {
        super(firstName, lastName, passport, orders);
        allIncluded = false;
        userType = travel_20190406.user.domain.UserType.SIMPLE_USER;
    }

    public UserType getUserType() {
        return userType;
    }
}
