/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190319.order.repo.impl;


import travel_20190319.city.domain.City;
import travel_20190319.common.business.service.SortType;
import travel_20190319.country.domain.BaseCountry;
import travel_20190319.order.domain.Order;
import travel_20190319.order.repo.OrderRepo;
import travel_20190319.order.search.OrderSearchCondition;
import travel_20190319.storage.SequenceGenerator;
import travel_20190319.user.domain.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static travel_20190319.storage.Storage.*;


/**
 * @author Виталий
 */
public class OrderMemoryListRepo implements OrderRepo {


    @Override
    public List<Order> findByCondition(OrderSearchCondition searchCondition) {
        List<Order> foundOrders = new ArrayList<>();
        for (Order order : orders) {
            boolean isMatchUserType = searchCondition != null &&
                    (searchCondition.getUserType().name().equals(UserType.ANY_TYPE.name()) ||
                            order.getUser().getUserType().name().equals(searchCondition.getUserType().name()));
            if (!isMatchUserType)
                continue;

            for(BaseCountry country : order.getCountries()) {//for (int i = 0; i < order.getCountries().size(); i++) {
                if(!country.getName().equals(searchCondition.getCountry().getName()))//if (!order.getCountries().contains(searchCondition.getCountry()))//if (!order.getCountries().contains(countries.get(i)))
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

    /*@Override
    public void deleteCityFromOrder(order targetOrder, BaseCountry targetCountry, city targetCity) {
        for (BaseCountry country : targetOrder.getCountries()) {
            if (country.equals(targetCountry)) {
                country.getCities().remove(targetCity);
                return;
            }
        }
    }*/

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
            for (BaseCountry country : order.getCountries()) {
                System.out.println("BaseCountry: " + country.getName());
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



