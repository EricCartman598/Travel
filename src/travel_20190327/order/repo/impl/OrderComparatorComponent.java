package travel_20190327.order.repo.impl;

import travel_20190327.country.domain.BaseCountry;
import travel_20190327.order.domain.Order;

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
