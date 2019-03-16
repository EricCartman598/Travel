package travel_20190315.common.business.application;

import travel_20190315.order.service.OrderService;
import travel_20190315.user.service.UserService;
import travel_20190315.city.service.CityService;
import travel_20190315.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
