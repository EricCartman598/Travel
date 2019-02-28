/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190228.User.Domain;


import Travel_20190228.Common.Business.Domain.BaseDomain;
import Travel_20190228.Order.Domain.Order;

import java.util.List;

/**
 * @author Виталий
 */
public abstract class User extends BaseDomain {
    protected String firstName;
    protected String lastName;
    protected Passport passport;
    protected List<Order> orders;
    boolean allIncluded;
    UserType userType;

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

    public void setPassport(Passport passport) {
        this.passport = passport;
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
