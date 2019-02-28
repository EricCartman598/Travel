package Travel_20190228.Common.Business.Application;

import Travel_20190228.City.Service.CityService;
import Travel_20190228.Country.Service.CountryService;
import Travel_20190228.Order.Service.OrderService;
import Travel_20190228.User.Service.UserService;

public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
