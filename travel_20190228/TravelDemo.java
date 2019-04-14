package main.java.travel_20190228;

import main.java.travel_20190228.City.Service.CityService;
import main.java.travel_20190228.Common.Business.Application.ServiceSupplier;
import main.java.travel_20190228.Common.Business.Application.StorageType;
import main.java.travel_20190228.Country.Service.CountryService;
import main.java.travel_20190228.Order.Service.OrderService;
import main.java.travel_20190228.User.Service.UserService;

public class TravelDemo {

    public static void main(String[] args) {
        ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

        CityService cityService = serviceSupplier.getCityService();
        CountryService countryService = ServiceSupplier.getInstance().getCountryService();
        UserService userService = ServiceSupplier.getInstance().getUserService();
        OrderService orderService = ServiceSupplier.getInstance().getOrderService();
    }



}
