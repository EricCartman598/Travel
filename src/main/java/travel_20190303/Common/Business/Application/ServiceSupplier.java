package main.java.travel_20190303.Common.Business.Application;

import main.java.travel_20190303.Order.Service.OrderService;
import main.java.travel_20190303.User.Service.UserService;
import main.java.travel_20190303.City.Service.CityService;
import main.java.travel_20190303.Common.Business.Application.Impl.MemoryListServiceFactory;
import main.java.travel_20190303.Country.Service.CountryService;


public final class ServiceSupplier {

    private static ServiceSupplier serviceSupplier;
    private ServiceFactory serviceFactory;

    private ServiceSupplier(StorageType storageType) {
        initServiceFactory(storageType);
    }

    public static ServiceSupplier newInstance(StorageType storageType)
    {
        if (serviceSupplier == null) {
            serviceSupplier = new ServiceSupplier(storageType);
        }

        return serviceSupplier;
    }

    public static ServiceSupplier getInstance() {
        return serviceSupplier;
    }

    private void initServiceFactory(StorageType storageType) {
        switch(storageType) {
            case MEMORY_ARRAY:
                //serviceFactory = new ;
                break;

            case MEMORY_LIST:
                serviceFactory = new MemoryListServiceFactory();
                break;
        }
    }

    public CityService getCityService() {
        return serviceFactory.getCityService();
    }

    public CountryService getCountryService() {
        return serviceFactory.getCountryService();
    }

    public OrderService getOrderService() {
        return serviceFactory.getOrderService();
    }

    public UserService getUserService() {
        return serviceFactory.getUserService();
    }
}
