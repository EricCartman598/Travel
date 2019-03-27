/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190322.order.service.impl;


import main.java.travel_20190322.city.domain.City;
import main.java.travel_20190322.common.business.exceptions.BasicTravelCheckedException;
import main.java.travel_20190322.common.business.exceptions.NoSuchCityException;
import main.java.travel_20190322.common.business.exceptions.NoSuchCountryException;
import main.java.travel_20190322.common.solution.search.Paginator;
import main.java.travel_20190322.country.domain.BaseCountry;
import main.java.travel_20190322.order.domain.Order;
import main.java.travel_20190322.order.repo.OrderRepo;
import main.java.travel_20190322.order.search.OrderSearchCondition;
import main.java.travel_20190322.order.service.OrderService;

import java.util.List;

import static main.java.travel_20190322.storage.Storage.cities;
import static main.java.travel_20190322.storage.Storage.countries;

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
            /*try {
                checkOrderPossibility(data);
                orderRepo.add(data);
            } catch (BasicTravelCheckedException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getErrorCode());
            } catch (Exception e) {
                e.printStackTrace();
            }*/

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

