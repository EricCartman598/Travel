package travel_20190406.common.business.application.impl;

import travel_20190406.order.repo.impl.OrderMemoryListRepo;
import travel_20190406.order.service.impl.OrderMemoryListService;
import travel_20190406.order.service.OrderService;
import travel_20190406.user.repo.impl.UserMemoryListRepo;
import travel_20190406.user.service.impl.UserMemoryListService;
import travel_20190406.user.service.UserService;
import travel_20190406.city.repo.impl.CityMemoryListRepo;
import travel_20190406.city.service.CityService;
import travel_20190406.city.service.impl.CityMemoryListService;
import travel_20190406.common.business.application.ServiceFactory;
import travel_20190406.country.repo.impl.CountryMemoryListRepo;
import travel_20190406.country.service.CountryService;
import travel_20190406.country.service.impl.CountryMemoryListService;

public class MemoryListServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityMemoryListService(new CityMemoryListRepo(), new OrderMemoryListRepo());
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
