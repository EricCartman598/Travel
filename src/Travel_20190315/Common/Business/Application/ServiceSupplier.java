package Travel_20190315.Common.Business.Application;

import Travel_20190315.City.Service.CityService;
import Travel_20190315.Common.Business.Application.Impl.MemoryListServiceFactory;
import Travel_20190315.Common.Business.Application.ServiceFactory;
import Travel_20190315.Common.Business.Application.StorageType;
import Travel_20190315.Country.Service.CountryService;
import Travel_20190315.Order.Service.OrderService;
import Travel_20190315.User.Service.UserService;


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
