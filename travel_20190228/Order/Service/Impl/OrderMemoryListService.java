/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190228.Order.Service.Impl;



import main.java.travel_20190228.Country.Domain.Country;
import main.java.travel_20190228.Country.Service.CountryService;
import main.java.travel_20190228.Country.Service.Impl.CountryMemoryListService;
import main.java.travel_20190228.Order.Domain.Order;
import main.java.travel_20190228.Order.Repos.Impl.OrderMemoryListRepos;
import main.java.travel_20190228.Order.Repos.OrderRepos;
import main.java.travel_20190228.Order.Search.OrderSearchCondition;
import main.java.travel_20190228.Order.Service.OrderService;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class OrderMemoryListService implements OrderService {

    private OrderRepos orderRepos = new OrderMemoryListRepos();
    private CountryService countryService = new CountryMemoryListService();

    @Override
    public void addOrder(Order order) {
        orderRepos.addOrder(order);

        for(Country country : order.getCountries())
            countryService.addCountry(country);
    }

    @Override
    public Order findOrderById(Long id) {
        if(id != null)
            return orderRepos.findOrderById(id);

        return null;
    }

    @Override
    public List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition) {
        return orderRepos.findOrderByCondition(orderSearchCondition);
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            orderRepos.deleteById(id);
    }

    @Override
    public void printAll() {
        orderRepos.printAll();
    }

    @Override
    public void update() {
        orderRepos.update();
    }


}
