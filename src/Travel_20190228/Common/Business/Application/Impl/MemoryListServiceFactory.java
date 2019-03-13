package Travel_20190228.Common.Business.Application.Impl;

import Travel_20190228.City.Service.CityService;
import Travel_20190228.City.Service.Impl.CityMemoryListService;
import Travel_20190228.Common.Business.Application.ServiceFactory;
import Travel_20190228.Country.Service.CountryService;
import Travel_20190228.Country.Service.Impl.CountryMemoryListService;
import Travel_20190228.Order.Service.Impl.OrderMemoryListService;
import Travel_20190228.Order.Service.OrderService;
import Travel_20190228.User.Service.Impl.UserMemoryListService;
import Travel_20190228.User.Service.UserService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService();
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService();
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryListService();
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryListService();
    }
}
