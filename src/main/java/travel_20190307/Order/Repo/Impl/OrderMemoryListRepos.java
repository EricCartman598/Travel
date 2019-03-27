/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190307.Order.Repo.Impl;


import main.java.travel_20190307.City.Domain.City;
import main.java.travel_20190307.Common.Business.Service.SortType;
import main.java.travel_20190307.Country.Domain.Country;
import main.java.travel_20190307.Order.Domain.Order;
import main.java.travel_20190307.Order.Repo.OrderRepo;
import main.java.travel_20190307.Order.Search.OrderSearchCondition;
import main.java.travel_20190307.Storage.SequenceGenerator;
import main.java.travel_20190307.User.Domain.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static main.java.travel_20190307.Storage.Storage.*;


/**
 * @author Виталий
 */
public class OrderMemoryListRepos implements OrderRepo {


    @Override
    public List<Order> findByCondition(OrderSearchCondition searchCondition) {
        List<Order> foundOrders = new ArrayList<>();
        for (Order order : orders) {
            boolean isMatchUserType = searchCondition != null &&
                    (searchCondition.getUserType().name().equals(UserType.ANY_TYPE.name()) ||
                            order.getUser().getUserType().name().equals(searchCondition.getUserType().name()));
            if (!isMatchUserType)
                continue;

            for (int i = 0; i < order.getCountries().size(); i++) {
                if (!order.getCountries().contains(searchCondition.getCountry()))//if (!order.getCountries().contains(countries.get(i)))
                    continue;
                else
                    foundOrders.add(order);

                // sorting
                Collections.sort(foundOrders, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        if (o1 == null || o2 == null)
                            return 0;

                        return o1.getUser().getFirstName().compareTo(o2.getUser().getFirstName());
                    }
                });

                if (searchCondition.getSortType() == SortType.DESC)
                    Collections.reverse(foundOrders);


            }
        }
        return foundOrders;

        // Don't search by city yet

                /*if (orderSearchCondition.getCountry().getCities().isEmpty())
                    foundOrders.add(order);
                else {
                    for (city city : cities) {
                        if (order.getCountries().get(i).getCities().contains(orderSearchCondition.getCountry().))
                            foundOrders.add(order);
                    }
                }*/
    }

    @Override
    public void add(Order data) {
        data.setId(SequenceGenerator.generateSequence());
        orders.add(data);
    }

    @Override
    public Order findById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id))
                return order;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        orders.remove(findById(id));
    }

    @Override
    public void printAll() {
        for (Order order : orders) {
            System.out.println("user firstName: " + order.getUser().getFirstName() + "\r\n" +
                    "user firstName: " + order.getUser().getLastName());
            for (Country country : order.getCountries()) {
                System.out.println("Country: " + country.getName());
                for (City city : country.getCities()) {
                    System.out.println("city: " + city.getName());
                }
            }
            System.out.println("Price: " + order.getPrice());
        }
    }

    @Override
    public void update(Order data) {

    }
}



