package main.java.travel_20190303.Common.Business.Application.Impl;

import main.java.travel_20190303.Order.Repos.Impl.OrderMemoryListRepos;
import main.java.travel_20190303.Order.Service.Impl.OrderMemoryListService;
import main.java.travel_20190303.Order.Service.OrderService;
import main.java.travel_20190303.User.Repos.Impl.UserMemoryListRepos;
import main.java.travel_20190303.User.Service.Impl.UserMemoryListService;
import main.java.travel_20190303.User.Service.UserService;
import main.java.travel_20190303.City.Repos.Impl.CityMemoryListRepos;
import main.java.travel_20190303.City.Service.CityService;
import main.java.travel_20190303.City.Service.Impl.CityMemoryListService;
import main.java.travel_20190303.Common.Business.Application.ServiceFactory;
import main.java.travel_20190303.Country.Repos.Impl.CountryMemoryListRepos;
import main.java.travel_20190303.Country.Service.CountryService;
import main.java.travel_20190303.Country.Service.Impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepos());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService(new CountryMemoryListRepos(), new CityMemoryListRepos());
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
