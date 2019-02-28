package Travel_20190228;

import Travel_20190228.City.Service.CityService;
import Travel_20190228.Common.Business.Application.ServiceSupplier;
import Travel_20190228.Common.Business.Application.StorageType;
import Travel_20190228.Country.Service.CountryService;
import Travel_20190228.Order.Service.OrderService;
import Travel_20190228.User.Service.UserService;

public class TravelDemo {

    public static void main(String[] args) {
        ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

        CityService cityService = serviceSupplier.getCityService();
        CountryService countryService = ServiceSupplier.getInstance().getCountryService();
        UserService userService = ServiceSupplier.getInstance().getUserService();
        OrderService orderService = ServiceSupplier.getInstance().getOrderService();
    }



}
