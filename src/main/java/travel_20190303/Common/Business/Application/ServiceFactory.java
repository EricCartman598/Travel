package Travel_20190303.Common.Business.Application;

import Travel_20190303.Order.Service.OrderService;
import Travel_20190303.User.Service.UserService;
import Travel_20190303.City.Service.CityService;
import Travel_20190303.Country.Service.CountryService;


public interface ServiceFactory {
    CityService getCityService();
    CountryService getCountryService();
    OrderService getOrderService();
    UserService getUserService();
}
