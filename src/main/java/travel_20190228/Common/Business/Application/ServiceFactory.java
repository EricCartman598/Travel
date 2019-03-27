package main.java.travel_20190228.Common.Business.Application;

import main.java.travel_20190228.City.Service.CityService;
import main.java.travel_20190228.Country.Service.CountryService;
import main.java.travel_20190228.Order.Service.OrderService;
import main.java.travel_20190228.User.Service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
