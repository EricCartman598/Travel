package main.java.travel_20190322.common.business.application.impl;

import main.java.travel_20190322.order.repo.impl.OrderMemoryListRepo;
import main.java.travel_20190322.order.service.impl.OrderMemoryListService;
import main.java.travel_20190322.order.service.OrderService;
import main.java.travel_20190322.user.repo.impl.UserMemoryListRepo;
import main.java.travel_20190322.user.service.impl.UserMemoryListService;
import main.java.travel_20190322.user.service.UserService;
import main.java.travel_20190322.city.repo.impl.CityMemoryListRepo;
import main.java.travel_20190322.city.service.CityService;
import main.java.travel_20190322.city.service.impl.CityMemoryListService;
import main.java.travel_20190322.common.business.application.ServiceFactory;
import main.java.travel_20190322.country.repo.impl.CountryMemoryListRepo;
import main.java.travel_20190322.country.service.CountryService;
import main.java.travel_20190322.country.service.impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepo(), new OrderMemoryListRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService(new CountryMemoryListRepo(), new CityMemoryListRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryListService(new OrderMemoryListRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryListService(new UserMemoryListRepo());
    }
}
