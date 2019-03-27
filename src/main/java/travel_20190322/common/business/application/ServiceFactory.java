package main.java.travel_20190322.common.business.application;

import main.java.travel_20190322.order.service.OrderService;
import main.java.travel_20190322.user.service.UserService;
import main.java.travel_20190322.city.service.CityService;
import main.java.travel_20190322.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
