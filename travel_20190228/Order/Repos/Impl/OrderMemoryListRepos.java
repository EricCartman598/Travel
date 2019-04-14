/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190228.Order.Repos.Impl;

import main.java.travel_20190228.City.Domain.City;
import main.java.travel_20190228.Country.Domain.Country;
import main.java.travel_20190228.Order.Domain.Order;
import main.java.travel_20190228.Order.Repos.OrderRepos;
import main.java.travel_20190228.Order.Search.OrderSearchCondition;
import main.java.travel_20190228.Storage.Storage;
import main.java.travel_20190228.User.Domain.User;
import main.java.travel_20190228.User.Domain.UserType;

import java.util.ArrayList;
import java.util.List;

import static main.java.travel_20190228.Storage.Storage.*;


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
            System.out.println("user firstName: " + order.getUser().getFirstName() + "\r\n" +
                    "user firstName: " + order.getUser().getLastName() + "\r\n");
            for (Country country : order.getCountries()) {
                System.out.println(country.getName());
            }
            System.out.println(order.getPrice());
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

            for (int i = 0; i < countries.size(); i++) {
                if (!order.getCountries().contains(countries.get(i)))
                    continue;

                if (orderSearchCondition.getCountry().getCities().isEmpty())
                    foundOrders.add(order);
                else {
                    for (City city : cities) {
                        if (order.getCountries().get(i).getCities().contains(city))
                            foundOrders.add(order);
                    }
                }
            }
        }
        return foundOrders;
    }
}

