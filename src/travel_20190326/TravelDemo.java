package travel_20190326;


import travel_20190326.city.domain.City;
import travel_20190326.city.service.CityService;
import travel_20190326.common.business.application.ServiceSupplier;
import travel_20190326.common.business.application.StorageType;
import travel_20190326.common.business.exceptions.CannotDeleteCityException;
import travel_20190326.common.business.search.SortOrderDirection;
import travel_20190326.common.solution.search.Paginator;
import travel_20190326.country.domain.BaseCountry;
import travel_20190326.country.service.CountryService;
import travel_20190326.order.domain.Order;
import travel_20190326.order.search.OrderSearchCondition;
import travel_20190326.order.service.OrderService;
import travel_20190326.reporting.ExportData;
import travel_20190326.reporting.impl.ExportDataToTxtFile;
import travel_20190326.storage.loadinitialdata.StorageInitor;
import travel_20190326.storage.loadinitialdata.impl.MultiThreadReader;
import travel_20190326.user.domain.SimpleUser;
import travel_20190326.user.domain.User;
import travel_20190326.user.domain.UserType;
import travel_20190326.user.domain.VipUser;
import travel_20190326.user.service.UserService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static travel_20190326.storage.Storage.cities;
import static travel_20190326.storage.Storage.orders;


public class TravelDemo {

    private static ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

    private static CityService cityService = serviceSupplier.getCityService();
    private static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    public static UserService userService = ServiceSupplier.getInstance().getUserService();
    private static OrderService orderService = ServiceSupplier.getInstance().getOrderService();

    public static void main(String[] args) {

        MultiThreadReader reader = new MultiThreadReader();
        reader.getDataFromFiles("resources/countries_part1.xml", "resources/countries_part2.xml");

        System.out.println("ok");

        StorageInitor storageInitor = new StorageInitor(true);
        try {
            storageInitor.initCountryStorageFromFile(countryService,
                    "resources/countries.xml", StorageInitor.DataSourceType.XML_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("data has been imported");
        cityService.printAll(new Paginator(3, 1));
        countryService.printAll(new Paginator(3, 1));


        createNewOrder("Masha", "Ivanov", UserType.SIMPLE_USER, "444", "12547",
                100.0, "USA", Arrays.asList("New-York", "Chicago", "Los-Angeles"));

        createNewOrder("Ivan", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                200.0, "Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));

        createNewOrder("Masha", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                300.0, "Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));

        createNewOrder("Agent007", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                400.0, "Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));

        createNewOrder("Vera", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                500.0, "Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                600.0, "USA", Arrays.asList("Los-Angeles"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                700.0, "USA", Arrays.asList("Los-Angeles"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                800.0, "USA", Arrays.asList("Los-Angeles"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                900.0, "USA", Arrays.asList("Los-Angeles"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                1000.0, "USA", Arrays.asList("Los-Angeles"));

        OrderSearchCondition orderSearchCondition = new OrderSearchCondition("Ukraine", SortOrderDirection.ASC, new Paginator(3, 1));
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
            cityService.deleteByEntity(cities.get(1));
        } catch (CannotDeleteCityException e) {
            System.out.println(e.getMessage());
        }

        countryService.printAll(new Paginator(3, 1));
        cityService.printAll(new Paginator(3, 1));
        System.out.println("---------------------------\r\n");
        orderService.printAll(new Paginator(3, 1));
        //orderService.printAll(null);


        String s1 = "qwerty";
        String s2 = "qwerty";

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

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
        /*
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
        }*/
        orderingCountry.add(new BaseCountry(countryName));
        orderingCountry.get(0).setId(countryService.findByName(orderingCountry.get(0).getName()).getId());

        for(String s : citiesNames) {
            orderingCountry.get(0).getCities().add(new City(s));
        }
        for(City city : orderingCountry.get(0).getCities()) {
            city.setId(cityService.findByName(city.getName()).getId());
        }

        //orderingCountry.add(countryService.findByName(countryName));
        //for (String str : citiesNames) {
        //    orderingCountry.get(0).getCities().add(cityService.findByName(str));
        //}

        /*Iterator<City> iter = orderingCountry.get(0).getCities().iterator();
        while (iter.hasNext()) {
            City city = iter.next();
            if (!citiesNames.contains(city.getName())) {
                iter.remove();
            }
        }*/

        Order order = new Order(user, price, orderingCountry);
        orderService.add(order);
    }

    public static void createNewUser() {
    }

    private static void callUser(String userName, String userPhoneNumber) {
        System.out.println("call user " + userName + " with phone number " + userPhoneNumber);
    }
}
