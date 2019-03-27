package travel_20190327.common.business.application;

import travel_20190327.order.service.OrderService;
import travel_20190327.user.service.UserService;
import travel_20190327.city.service.CityService;
import travel_20190327.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
