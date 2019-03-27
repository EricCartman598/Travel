package main.java.travel_20190319.common.business.application;

import main.java.travel_20190319.order.service.OrderService;
import main.java.travel_20190319.user.service.UserService;
import main.java.travel_20190319.city.service.CityService;
import main.java.travel_20190319.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
