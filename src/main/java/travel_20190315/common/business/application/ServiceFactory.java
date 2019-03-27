package main.java.travel_20190315.common.business.application;

import main.java.travel_20190315.order.service.OrderService;
import main.java.travel_20190315.user.service.UserService;
import main.java.travel_20190315.city.service.CityService;
import main.java.travel_20190315.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
