package main.java.travel_20190322.order.repo.impl;

import main.java.travel_20190322.country.domain.BaseCountry;
import main.java.travel_20190322.order.domain.Order;

import java.util.Comparator;

public class OrderComparatorComponent {

    private OrderComparatorComponent() {
    }

    public static Comparator<Order> getComparatorByNameField() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getUser().getFirstName().compareTo(o2.getUser().getFirstName());
            }
        };
    }
}
