/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190322.city.service.impl;

import travel_20190322.city.domain.City;
import travel_20190322.city.repo.CityRepo;
import travel_20190322.city.search.CitySearchCondition;
import travel_20190322.city.service.CityService;
import travel_20190322.common.business.exceptions.CannotDeleteCityException;
import travel_20190322.common.business.exceptions.NeedToCancelOrderException;
import travel_20190322.country.domain.BaseCountry;
import travel_20190322.order.domain.Order;
import travel_20190322.order.repo.OrderRepo;

import java.util.ArrayList;
import java.util.List;

import static travel_20190322.storage.Storage.countries;
import static travel_20190322.storage.Storage.orders;


/**
 * @author Виталий
 */
public class CityMemoryListService implements CityService {

    private final CityRepo cityRepo;
    private final OrderRepo orderRepo;
    //private final CountryRepo countryRepo;// = new CountryMemoryListRepo();
    //private final OrderRepo orderRepo;// = new OrderMemoryListRepo();

    public CityMemoryListService(CityRepo cityRepo, OrderRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
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
    public void deleteByEntity(City city) throws CannotDeleteCityException {     //throws NeedToCancelOrderException {
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
                if (country.getCities().remove(targetCity))
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
    public void deleteById(Long id) throws CannotDeleteCityException {
        if (id != null) {
            boolean noOrders = (orderRepo.ordersByCity(id) == 0);
            if (noOrders) {
                cityRepo.deleteById(id);
            } else {
                throw new CannotDeleteCityException();
            }


            /*City targetCity = findById(id);
            cityRepo.deleteById(id);

            // check countries
            deleteUnexistingCityFromCountries(targetCity);

            // check orders
            List<Order> cancelledOrders = deleteUnexistingCityFromOrders(targetCity);

            // if smth bad, exception and call user
            if (!cancelledOrders.isEmpty()) {
                throw (new NeedToCancelOrderException(cancelledOrders));
            }*/
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

