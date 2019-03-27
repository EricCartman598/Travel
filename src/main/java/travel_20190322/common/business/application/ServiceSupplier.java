package main.java.travel_20190322.common.business.application;

import main.java.travel_20190322.city.service.CityService;
import main.java.travel_20190322.common.business.application.ServiceFactory;
import main.java.travel_20190322.common.business.application.StorageType;
import main.java.travel_20190322.common.business.application.impl.MemoryListServiceFactory;
import main.java.travel_20190322.country.service.CountryService;
import main.java.travel_20190322.order.service.OrderService;
import main.java.travel_20190322.user.service.UserService;


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
