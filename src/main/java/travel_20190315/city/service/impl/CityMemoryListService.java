/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190315.city.service.impl;

import main.java.travel_20190315.city.domain.City;
import main.java.travel_20190315.city.repo.CityRepo;
import main.java.travel_20190315.city.search.CitySearchCondition;
import main.java.travel_20190315.city.service.CityService;
import main.java.travel_20190315.common.business.exceptions.NeedToCancelOrderException;
import main.java.travel_20190315.country.domain.BaseCountry;
import main.java.travel_20190315.order.domain.Order;

import java.util.ArrayList;
import java.util.List;

import static main.java.travel_20190315.storage.Storage.countries;
import static main.java.travel_20190315.storage.Storage.orders;


/**
 * @author Виталий
 */
public class CityMemoryListService implements CityService {

    private final CityRepo cityRepo;
    //private final CountryRepo countryRepo;// = new CountryMemoryListRepo();
    //private final OrderRepo orderRepo;// = new OrderMemoryListRepo();

    public CityMemoryListService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }


    @Override
    public City findByName(String name) {
        if (!name.trim().isEmpty())
            return cityRepo.findByName(name);

        return null;
    }

    @Override
    public List<City> findByCondition(CitySearchCondition citySearchCondition) {
        return cityRepo.findByCondition(citySearchCondition);
    }

    @Override
    public void deleteByEntity(City city) throws NeedToCancelOrderException {
        deleteById(city.getId());
    }

    @Override
    public void add(City data) {
        if (data != null)
            cityRepo.add(data);
    }

    @Override
    public City findById(Long id) {
        if (id != null)
            return cityRepo.findById(id);

        return null;
    }

    private void deleteUnexistingCityFromCountries(City targetCity) {
        //CountryRepo countryRepo = new CountryMemoryListRepo();
        for (BaseCountry country : countries) {
            country.getCities().remove(targetCity);
            /*
            Iterator<city> cityIterator = country.getCities().iterator();
            while(cityIterator.hasNext()) {
                city city = cityIterator.next();
                if (city.equals(targetCity))
                    cityIterator.remove(); //countryRepo.deleteCityFromCountry(country, city);
            }
            */
        }
    }

    private List<Order> deleteUnexistingCityFromOrders(City targetCity) {
        //OrderRepo orderRepo = new OrderMemoryListRepo();
        List<Order> cancelledOrders = new ArrayList<>();
        for (Order order : orders) {
            for (BaseCountry country : order.getCountries()) {
                if(country.getCities().remove(targetCity))
                    cancelledOrders.add(order);
                /*for (city city : country.getCities()) {
                    if (city.equals(targetCity)) {
                        orderRepo.deleteCityFromOrder(order, country, city);
                        cancelledOrders.add(order);
                    }
                }*/
            }
        }
        return cancelledOrders;
    }

    @Override
    public void deleteById(Long id) throws NeedToCancelOrderException {
        if (id != null) {
            City targetCity = findById(id);
            cityRepo.deleteById(id);

            // check countries
            deleteUnexistingCityFromCountries(targetCity);

            // check orders
            List<Order> cancelledOrders = deleteUnexistingCityFromOrders(targetCity);

            // if smth bad, exception and call user
            if (!cancelledOrders.isEmpty()) {
                throw (new NeedToCancelOrderException(cancelledOrders));
            }
        }

    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

    @Override
    public void update(City data) {
        cityRepo.update(data);
    }
}

