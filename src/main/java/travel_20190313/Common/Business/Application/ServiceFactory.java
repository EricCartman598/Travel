package Travel_20190313.Common.Business.Application;

import Travel_20190313.Order.Service.OrderService;
import Travel_20190313.User.Service.UserService;
import Travel_20190313.City.Service.CityService;
import Travel_20190313.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
