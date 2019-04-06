package travel_20190406.common.business.application;

import travel_20190406.order.service.OrderService;
import travel_20190406.user.service.UserService;
import travel_20190406.city.service.CityService;
import travel_20190406.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
