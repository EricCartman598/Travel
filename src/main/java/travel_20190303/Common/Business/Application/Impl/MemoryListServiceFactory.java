package Travel_20190303.Common.Business.Application.Impl;

import Travel_20190303.Order.Repos.Impl.OrderMemoryListRepos;
import Travel_20190303.Order.Service.Impl.OrderMemoryListService;
import Travel_20190303.Order.Service.OrderService;
import Travel_20190303.User.Repos.Impl.UserMemoryListRepos;
import Travel_20190303.User.Service.Impl.UserMemoryListService;
import Travel_20190303.User.Service.UserService;
import Travel_20190303.City.Repos.Impl.CityMemoryListRepos;
import Travel_20190303.City.Service.CityService;
import Travel_20190303.City.Service.Impl.CityMemoryListService;
import Travel_20190303.Common.Business.Application.ServiceFactory;
import Travel_20190303.Country.Repos.Impl.CountryMemoryListRepos;
import Travel_20190303.Country.Service.CountryService;
import Travel_20190303.Country.Service.Impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepos());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService(new CountryMemoryListRepos(), new CityMemoryListRepos());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderMemoryListService(new OrderMemoryListRepos());
    }

    @Override
    public UserService getUserService() {
        return new UserMemoryListService(new UserMemoryListRepos());
    }
}
