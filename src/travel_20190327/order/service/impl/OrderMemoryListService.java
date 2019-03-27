/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190327.order.service.impl;


import travel_20190327.city.domain.City;
import travel_20190327.common.business.exceptions.BasicTravelCheckedException;
import travel_20190327.common.business.exceptions.NoSuchCityException;
import travel_20190327.common.business.exceptions.NoSuchCountryException;
import travel_20190327.common.solution.search.Paginator;
import travel_20190327.country.domain.BaseCountry;
import travel_20190327.order.domain.Order;
import travel_20190327.order.repo.OrderRepo;
import travel_20190327.order.search.OrderSearchCondition;
import travel_20190327.order.service.OrderService;

import java.util.Collection;
import java.util.List;

import static travel_20190327.storage.Storage.cities;
import static travel_20190327.storage.Storage.countries;

/**
 * @author Виталий
 */
public class OrderMemoryListService implements OrderService {

    private final OrderRepo orderRepo;

    public OrderMemoryListService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    @Override
    public List<Order> findByCondition(OrderSearchCondition searchCondition) {
        return orderRepo.findByCondition(searchCondition);
    }

    /*
    @Override
    public void deleteCityFromOrder(order targetOrder, Country targetCountry, city targetCity) {
        orderRepo.deleteCityFromOrder(targetOrder, targetCountry, targetCity);
    }
    */

    // check are desired city and country exists
    private void checkOrderPossibility(Order order) throws NoSuchCountryException, NoSuchCityException {
        for (BaseCountry country : order.getCountries()) {
            if (!countries.contains(country))
                throw new NoSuchCountryException();
            else {
                for (City city : country.getCities()) {
                    if (!cities.contains(city))
                        throw new NoSuchCityException();
                }
            }
        }
    }

    @Override
    public void add(Order data) {
        if (data != null) {
            orderRepo.add(data);
        }
    }

    @Override
    public void add(Collection<Order> data) {
        if (data != null) {
            for (Order order : data) {
                add(order);
            }
        }
    }

    @Override
    public Order findById(Long id) {
        if (id != null)
            return orderRepo.findById(id);

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (id != null)
            orderRepo.deleteById(id);
    }

    @Override
    public void printAll(Paginator paginator) {
        orderRepo.printAll(paginator);
    }

    @Override
    public void update(Order data) {
        orderRepo.update(data);
    }
}

