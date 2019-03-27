package main.java.travel_20190303.Common.Business.Application;

import main.java.travel_20190303.Order.Service.OrderService;
import main.java.travel_20190303.User.Service.UserService;
import main.java.travel_20190303.City.Service.CityService;
import main.java.travel_20190303.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
