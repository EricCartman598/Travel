package main.java.travel_20190307.Common.Business.Application.Impl;

import main.java.travel_20190307.Order.Repo.Impl.OrderMemoryListRepos;
import main.java.travel_20190307.Order.Service.Impl.OrderMemoryListService;
import main.java.travel_20190307.Order.Service.OrderService;
import main.java.travel_20190307.User.Repo.Impl.UserMemoryListRepos;
import main.java.travel_20190307.User.Service.Impl.UserMemoryListService;
import main.java.travel_20190307.User.Service.UserService;
import main.java.travel_20190307.City.Repo.Impl.CityMemoryListRepo;
import main.java.travel_20190307.City.Service.CityService;
import main.java.travel_20190307.City.Service.Impl.CityMemoryListService;
import main.java.travel_20190307.Common.Business.Application.ServiceFactory;
import main.java.travel_20190307.Country.Repo.Impl.CountryMemoryListRepos;
import main.java.travel_20190307.Country.Service.CountryService;
import main.java.travel_20190307.Country.Service.Impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService(new CountryMemoryListRepos(), new CityMemoryListRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryListService(new OrderMemoryListRepos());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryListService(new UserMemoryListRepos());
    }
}
