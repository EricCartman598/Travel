package main.java.travel_20190313.Common.Business.Application;

import main.java.travel_20190313.Order.Service.OrderService;
import main.java.travel_20190313.User.Service.UserService;
import main.java.travel_20190313.City.Service.CityService;
import main.java.travel_20190313.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
