package Travel_20190315.Common.Business.Application;

import Travel_20190315.Order.Service.OrderService;
import Travel_20190315.User.Service.UserService;
import Travel_20190315.City.Service.CityService;
import Travel_20190315.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
