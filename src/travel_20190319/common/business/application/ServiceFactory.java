package travel_20190319.common.business.application;

import travel_20190319.order.service.OrderService;
import travel_20190319.user.service.UserService;
import travel_20190319.city.service.CityService;
import travel_20190319.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
