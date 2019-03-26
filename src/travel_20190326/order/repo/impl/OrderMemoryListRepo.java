/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190326.order.repo.impl;


import travel_20190326.city.domain.City;
import travel_20190326.common.business.search.SortOrderDirection;
import travel_20190326.common.solution.search.Paginator;
import travel_20190326.common.solution.utils.CollectionUtils;
import travel_20190326.country.domain.BaseCountry;
import travel_20190326.order.domain.Order;
import travel_20190326.order.repo.OrderRepo;
import travel_20190326.order.repo.impl.OrderOrderingComponent;
import travel_20190326.order.search.OrderSearchCondition;
import travel_20190326.storage.SequenceGenerator;
import travel_20190326.user.domain.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static travel_20190326.storage.Storage.*;


/**
 * @author Виталий
 */
public class OrderMemoryListRepo implements OrderRepo {


    private List<Order> doSearch(OrderSearchCondition searchCondition) {
        List<Order> foundOrders = new ArrayList<>();
        for (Order order : orders) {
            boolean isMatchUserType = searchCondition != null &&
                    (searchCondition.getUserType().name().equals(UserType.ANY_TYPE.name()) ||
                            order.getUser().getUserType().name().equals(searchCondition.getUserType().name()));
            if (!isMatchUserType)
                continue;

            for (BaseCountry country : order.getCountries()) {//for (int i = 0; i < order.getCountries().size(); i++) {
                if (!country.getName().equals(searchCondition.getCountry().getName()))//if (!order.getCountries().contains(searchCondition.getCountry()))//if (!order.getCountries().contains(countries.get(i)))
                    continue;
                else
                    foundOrders.add(order);
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
    public List<Order> findByCondition(OrderSearchCondition searchCondition) {

        List<Order> foundOrders = doSearch(searchCondition);
        if (foundOrders.isEmpty())
            return null;

        if (searchCondition.getSortOrderDirection() != null) {
            OrderOrderingComponent orderingComponent = new OrderOrderingComponent();
            orderingComponent.applyOrdering(foundOrders, searchCondition);
        }

        if (searchCondition.getPaginator() != null)
            CollectionUtils.getPageableData(foundOrders,
                    searchCondition.getPaginator().getLimit(),
                    searchCondition.getPaginator().getOffset());

            return foundOrders;
    }

    @Override
    public long ordersByCountry(Long id) {
        long count = 0;
        for (Order order : orders) {
            List<BaseCountry> countries = order.getCountries();
            for (BaseCountry country : countries) {
                if (country.getId() == id)
                    count++;
            }
        }

        return count;
    }

    @Override
    public long ordersByCity(Long id) {
        long count = 0;
        for (Order order : orders) {
            List<BaseCountry> countries = order.getCountries();
            for (BaseCountry country : countries) {
                List<City> cities = country.getCities();
                for (City city : cities) {
                    if (city.getId() == id)
                        count++;
                }
            }
        }

        return count;
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
    public void printAll(Paginator paginator) {
        List<Order> printedOrders = orders;
        if (paginator != null) {

            int startPosition = paginator.getOffset();
            int endPosition = paginator.getLimit() + startPosition;
            try {
                printedOrders = orders.subList(startPosition, endPosition);
            } catch (Exception e) {
                printedOrders = orders;
            } finally {
                for (Order order : printedOrders) {
                    System.out.println("user firstName: " + order.getUser().getFirstName() + "\r\n" +
                            "user firstName: " + order.getUser().getLastName());
                    for (BaseCountry country : order.getCountries()) {
                        System.out.println("Country: " + country.getName());
                        for (City city : country.getCities()) {
                            System.out.println("city: " + city.getName());
                        }
                    }
                    System.out.println("Price: " + order.getPrice());
                }
            }
        }
    }

    @Override
    public void update(Order data) {

    }
}



