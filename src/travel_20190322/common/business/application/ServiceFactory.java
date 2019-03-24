package travel_20190322.common.business.application;

import travel_20190322.order.service.OrderService;
import travel_20190322.user.service.UserService;
import travel_20190322.city.service.CityService;
import travel_20190322.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
