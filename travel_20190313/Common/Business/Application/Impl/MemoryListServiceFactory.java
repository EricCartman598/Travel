package main.java.travel_20190313.Common.Business.Application.Impl;

import main.java.travel_20190313.Order.Repo.Impl.OrderMemoryListRepo;
import main.java.travel_20190313.Order.Service.Impl.OrderMemoryListService;
import main.java.travel_20190313.Order.Service.OrderService;
import main.java.travel_20190313.User.Repo.Impl.UserMemoryListRepo;
import main.java.travel_20190313.User.Service.Impl.UserMemoryListService;
import main.java.travel_20190313.User.Service.UserService;
import main.java.travel_20190313.City.Repo.Impl.CityMemoryListRepo;
import main.java.travel_20190313.City.Service.CityService;
import main.java.travel_20190313.City.Service.Impl.CityMemoryListService;
import main.java.travel_20190313.Common.Business.Application.ServiceFactory;
import main.java.travel_20190313.Country.Repo.Impl.CountryMemoryListRepo;
import main.java.travel_20190313.Country.Service.CountryService;
import main.java.travel_20190313.Country.Service.Impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepo());
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
