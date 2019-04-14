package main.java.travel_20190307.Common.Business.Application;

import main.java.travel_20190307.Order.Service.OrderService;
import main.java.travel_20190307.User.Service.UserService;
import main.java.travel_20190307.City.Service.CityService;
import main.java.travel_20190307.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
