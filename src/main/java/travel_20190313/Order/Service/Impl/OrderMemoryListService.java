/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190313.Order.Service.Impl;


import Travel_20190313.City.Domain.City;
import Travel_20190313.Common.Business.Exceptions.NoSuchCityException;
import Travel_20190313.Common.Business.Exceptions.NoSuchCountryException;
import Travel_20190313.Order.Domain.Order;
import Travel_20190313.Order.Repo.OrderRepo;
import Travel_20190313.Order.Search.OrderSearchCondition;
import Travel_20190313.Order.Service.OrderService;
import Travel_20190313.Country.Domain.Country;

import java.util.List;

import static Travel_20190313.Storage.Storage.cities;
import static Travel_20190313.Storage.Storage.countries;

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

    @Override
    public void deleteCityFromOrder(Order targetOrder, Country targetCountry, City targetCity) {
        orderRepo.deleteCityFromOrder(targetOrder, targetCountry, targetCity);
    }

    // check are desired city and country exists
    private void CheckOrderPossibility(Order order) throws NoSuchCountryException, NoSuchCityException {
        for (Country country : order.getCountries()) {
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
    public void add(Order data) throws NoSuchCountryException, NoSuchCityException {
        if (data != null) {
            CheckOrderPossibility(data);
            orderRepo.add(data);
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
    public void printAll() {
        orderRepo.printAll();
    }

    @Override
    public void update(Order data) {
        orderRepo.update(data);
    }
}

