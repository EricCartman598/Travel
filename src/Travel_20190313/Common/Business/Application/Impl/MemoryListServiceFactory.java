package Travel_20190313.Common.Business.Application.Impl;

import Travel_20190313.Order.Repo.Impl.OrderMemoryListRepo;
import Travel_20190313.Order.Service.Impl.OrderMemoryListService;
import Travel_20190313.Order.Service.OrderService;
import Travel_20190313.User.Repo.Impl.UserMemoryListRepo;
import Travel_20190313.User.Service.Impl.UserMemoryListService;
import Travel_20190313.User.Service.UserService;
import Travel_20190313.City.Repo.Impl.CityMemoryListRepo;
import Travel_20190313.City.Service.CityService;
import Travel_20190313.City.Service.Impl.CityMemoryListService;
import Travel_20190313.Common.Business.Application.ServiceFactory;
import Travel_20190313.Country.Repo.Impl.CountryMemoryListRepo;
import Travel_20190313.Country.Service.CountryService;
import Travel_20190313.Country.Service.Impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService(new CountryMemoryListRepo(), new CityMemoryListRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryListService(new OrderMemoryListRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryListService(new UserMemoryListRepo());
    }
}
