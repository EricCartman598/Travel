package main.java.travel_20190319;


import main.java.travel_20190319.city.domain.City;
import main.java.travel_20190319.city.service.CityService;
import main.java.travel_20190319.common.business.application.ServiceSupplier;
import main.java.travel_20190319.common.business.application.StorageType;
import main.java.travel_20190319.common.business.exceptions.NeedToCancelOrderException;
import main.java.travel_20190319.common.business.service.SortType;
import main.java.travel_20190319.country.domain.BaseCountry;
import main.java.travel_20190319.country.domain.ColdCountry;
import main.java.travel_20190319.country.domain.HotCountry;
import main.java.travel_20190319.country.service.CountryService;
import main.java.travel_20190319.order.domain.Order;
import main.java.travel_20190319.order.search.OrderSearchCondition;
import main.java.travel_20190319.order.service.OrderService;
import main.java.travel_20190319.reporting.ExportData;
import main.java.travel_20190319.reporting.impl.ExportDataToTxtFile;
import main.java.travel_20190319.storage.loadinitialdata.StorageInitor;
import main.java.travel_20190319.user.domain.SimpleUser;
import main.java.travel_20190319.user.domain.User;
import main.java.travel_20190319.user.domain.UserType;
import main.java.travel_20190319.user.domain.VipUser;
import main.java.travel_20190319.user.service.UserService;

import java.io.FileNotFoundException;
import java.util.*;

import static main.java.travel_20190319.storage.Storage.cities;
import static main.java.travel_20190319.storage.Storage.orders;


public class TravelDemo {

    private static ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

    private static CityService cityService = serviceSupplier.getCityService();
    private static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    public static UserService userService = ServiceSupplier.getInstance().getUserService();
    private static OrderService orderService = ServiceSupplier.getInstance().getOrderService();

    public static void main(String[] args) {

        StorageInitor storageInitor = new StorageInitor();
        try {
            storageInitor.initCountryStorageFromFile(countryService,
                            "resources/countries.xml", StorageInitor.DataSourceType.XML_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("data has been imported");
        cityService.printAll();
        countryService.printAll();


        createNewOrder("Ivan", "Ivanov", UserType.SIMPLE_USER, "444", "12547",
                500.0, "USA", Arrays.asList("New-York", "Los-Angeles"));

        createNewOrder("Masha", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                875.50, "Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));

        // no city "Melburn" into cities storage -- exception
        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                150000.0, "USA", Arrays.asList("Melburn"));

        OrderSearchCondition orderSearchCondition = new OrderSearchCondition("Ukraine", SortType.DESC);
        List<Order> foundOrders = orderService.findByCondition(orderSearchCondition);

        for (Order order : foundOrders)
            System.out.println(order.getUser().getFirstName());

        try {
            ExportData exporting = new ExportDataToTxtFile();
            exporting.exportFile("D:\\report.txt", orders.get(0));
        } catch (FileNotFoundException e) {
            System.out.println("Error while recording file!");
        }

        try {
            cityService.deleteByEntity(cities.get(0));
        } catch (NeedToCancelOrderException e) {
            for (Order cancelledOrder : e.getCancelledOrders()) {
                callUser(cancelledOrder.getUser().getFirstName(), cancelledOrder.getUser().getPhoneNumber());
            }
        }

        countryService.printAll();
        cityService.printAll();
    }

    private static void createNewCity(String cityName) {
        cityService.add(new City(cityName));
    }

    private static void createNewCountry(String countryName, List<String> cityList) {
        BaseCountry country = new BaseCountry("USA", "English");
        List<City> cities = new ArrayList<>();
        for (String s : cityList) {
            cities.add(new City(s));
        }
        country.setName(countryName);
        country.setCities(cities);

        countryService.add(country);

    }

    private static void createNewOrder(String userName, String userLastName, UserType userType,
                                       String passportSerial, String passportNumber,
                                       Double price,
                                       String countryName,
                                       List<String> citiesNames) {

        User user;
        switch (userType) {
            case SIMPLE_USER:
                user = new SimpleUser(userName, userLastName);
                break;
            case VIP_USER:
                user = new VipUser(userName, userLastName);
                break;
            default:
                user = new SimpleUser(userName, userLastName);
        }

        User.Passport userPassport = user.new Passport(passportSerial, passportNumber);

        /*
        if(countryService.findByName(countryName) != null)
            orderingCountry.add(countryService.findByName(countryName));
        for(String cityName : citiesNames) {
            if(cityService.findByName(cityName) != null)
                orderingCountry.get(0).getCities().add(cityService.findByName(cityName));
        }
        */

        List<BaseCountry> orderingCountry = new ArrayList<>();
        switch(countryService.findByName(countryName).getDiscriminator()) {
            case HOT:
                orderingCountry.add(new HotCountry(countryName));
                break;
            case COLD:
                orderingCountry.add(new ColdCountry(countryName));
                break;
        }
        for(String cityName : citiesNames) {
            orderingCountry.get(0).getCities().add(new City(cityName));
        }

        Order order = new Order(user, price, orderingCountry);
        orderService.add(order);
    }

    public static void createNewUser() {
    }

    private static void callUser(String userName, String userPhoneNumber) {
        System.out.println("call user " + userName + " with phone number " + userPhoneNumber);
    }
}
