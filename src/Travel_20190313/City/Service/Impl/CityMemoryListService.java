/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190313.City.Service.Impl;

import Travel_20190313.City.Domain.City;
import Travel_20190313.City.Repo.CityRepo;
import Travel_20190313.City.Search.CitySearchCondition;
import Travel_20190313.City.Service.CityService;
import Travel_20190313.Common.Business.Exceptions.NeedToCancelOrderException;
import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Country.Repo.CountryRepo;
import Travel_20190313.Country.Repo.Impl.CountryMemoryListRepo;
import Travel_20190313.Country.Service.CountryService;
import Travel_20190313.Country.Service.Impl.CountryMemoryListService;
import Travel_20190313.Order.Domain.Order;
import Travel_20190313.Order.Repo.Impl.OrderMemoryListRepo;
import Travel_20190313.Order.Repo.OrderRepo;
import Travel_20190313.Order.Service.Impl.OrderMemoryListService;
import Travel_20190313.Order.Service.OrderService;

import java.util.ArrayList;
import java.util.List;

import static Travel_20190313.Storage.Storage.countries;
import static Travel_20190313.Storage.Storage.orders;


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
        CountryRepo countryRepo = new CountryMemoryListRepo();
        for (Country country : countries) {
            for (City city : country.getCities()) {
                if (city.equals(targetCity))
                    countryRepo.deleteCityFromCountry(country, city);
            }
        }
    }

    private List<Order> deleteUnexistingCityFromOrders(City targetCity) {
        OrderRepo orderRepo = new OrderMemoryListRepo();
        List<Order> cancelledOrders = new ArrayList<>();
        for (Order order : orders) {
            for (Country country : order.getCountries()) {
                for (City city : country.getCities()) {
                    if (city.equals(targetCity)) {
                        orderRepo.deleteCityFromOrder(order, country, city);
                        cancelledOrders.add(order);
                    }
                }
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
