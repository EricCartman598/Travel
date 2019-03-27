package Travel_20190307.Common.Business.Application;

import Travel_20190307.Order.Service.OrderService;
import Travel_20190307.User.Service.UserService;
import Travel_20190307.City.Service.CityService;
import Travel_20190307.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
