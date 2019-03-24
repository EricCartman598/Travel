/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190322.user.domain;


import travel_20190322.common.business.domain.BaseDomain;
import travel_20190322.order.domain.Order;
import travel_20190322.user.domain.UserType;

import java.util.List;

/**
 * @author Виталий
 */
public abstract class User extends BaseDomain<Long> {
    protected String firstName;
    protected String lastName;
    protected Passport passport;
    protected List<Order> orders;
    boolean allIncluded;
    UserType userType;
    String PhoneNumber;

    public class Passport {
        private String serial;
        private String number;

        public Passport(String serial, String number) {
            this.serial = serial;
            this.number = number;
        }

        public String getSerial() {
            return serial;
        }

        public String getNumber() {
            return number;
        }
    }

    public User(String firstName, String lastName, Passport passport) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, Passport passport, List<Order> orders) {
        super();
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPassport(String passportSerial, String passportNumber) {
        this.passport.serial = passportSerial;
        this.passport.number = passportNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isAllIncluded() {
        return allIncluded;
    }

    public UserType getUserType() {
        return userType;
    }
}
