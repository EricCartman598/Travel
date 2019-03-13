/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190303.Order.Repos.Impl;

import Travel_20190303.City.Domain.City;
import Travel_20190303.Common.Business.Service.SortType;
import Travel_20190303.Country.Domain.Country;
import Travel_20190303.Order.Domain.Order;
import Travel_20190303.Order.Repos.OrderRepos;
import Travel_20190303.Order.Search.OrderSearchCondition;
import Travel_20190303.Storage.Storage;
import Travel_20190303.User.Domain.User;
import Travel_20190303.User.Domain.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static Travel_20190303.Storage.Storage.*;


/**
 * @author Виталий
 */
public class OrderMemoryListRepos implements OrderRepos {

    private static long sequence = 0;

    @Override
    public void addOrder(Order order) {
        order.setId(generateSequence());
        orders.add(order);
    }

    @Override
    public Order findOrderById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id))
                return order;
        }

        return null;
    }

    @Override
    public void deleteById(long id) {
        orders.remove(findOrderById(id));

    }

    @Override
    public void printAll() {
        for (Order order : orders) {
            System.out.println("User firstName: " + order.getUser().getFirstName() + "\r\n" +
                    "User firstName: " + order.getUser().getLastName());
            for (Country country : order.getCountries()) {
                System.out.println("Country: " + country.getName());
                for(City city : country.getCities()) {
                    System.out.println("City: " + city.getName());
                }
            }
            System.out.println("Price: " + order.getPrice());
        }
    }

    @Override
    public void update() {
        orders = orders;
    }

    @Override
    public long generateSequence() {
        return ++sequence;
    }

    @Override
    public List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition) {
        List<Order> foundOrders = new ArrayList<>();
        for (Order order : orders) {
            boolean isMatchUserType = orderSearchCondition != null &&
                    (orderSearchCondition.getUserType().name().equals(UserType.ANY_TYPE.name()) ||
                            order.getUser().getUserType().name().equals(orderSearchCondition.getUserType().name()));
            if (!isMatchUserType)
                continue;

            for (int i = 0; i < order.getCountries().size(); i++) {
                if(!order.getCountries().contains(orderSearchCondition.getCountry()))//if (!order.getCountries().contains(countries.get(i)))
                    continue;
                else
                    foundOrders.add(order);

                // sorting
                Collections.sort(foundOrders, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        if(o1 == null || o2 == null)
                            return 0;

                        return o1.getUser().getFirstName().compareTo(o2.getUser().getFirstName());
                    }
                });

                if(orderSearchCondition.getSortType() == SortType.DESC)
                    Collections.reverse(foundOrders);

                // Don't search by city yet

                /*if (orderSearchCondition.getCountry().getCities().isEmpty())
                    foundOrders.add(order);
                else {
                    for (City city : cities) {
                        if (order.getCountries().get(i).getCities().contains(orderSearchCondition.getCountry().))
                            foundOrders.add(order);
                    }
                }*/
            }
        }
        return foundOrders;
    }
}

