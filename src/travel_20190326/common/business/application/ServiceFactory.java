package travel_20190326.common.business.application;

import travel_20190326.order.service.OrderService;
import travel_20190326.user.service.UserService;
import travel_20190326.city.service.CityService;
import travel_20190326.country.service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
