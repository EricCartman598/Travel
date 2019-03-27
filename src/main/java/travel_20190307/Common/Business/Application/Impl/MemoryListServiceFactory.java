package Travel_20190307.Common.Business.Application.Impl;

import Travel_20190307.Order.Repo.Impl.OrderMemoryListRepos;
import Travel_20190307.Order.Service.Impl.OrderMemoryListService;
import Travel_20190307.Order.Service.OrderService;
import Travel_20190307.User.Repo.Impl.UserMemoryListRepos;
import Travel_20190307.User.Service.Impl.UserMemoryListService;
import Travel_20190307.User.Service.UserService;
import Travel_20190307.City.Repo.Impl.CityMemoryListRepo;
import Travel_20190307.City.Service.CityService;
import Travel_20190307.City.Service.Impl.CityMemoryListService;
import Travel_20190307.Common.Business.Application.ServiceFactory;
import Travel_20190307.Country.Repo.Impl.CountryMemoryListRepos;
import Travel_20190307.Country.Service.CountryService;
import Travel_20190307.Country.Service.Impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryMemoryListService(new CountryMemoryListRepos(), new CityMemoryListRepo());
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
