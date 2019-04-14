package main.java.travel_20190313;


import main.java.travel_20190313.City.Domain.City;
import main.java.travel_20190313.City.Repo.Impl.CityMemoryListRepo;
import main.java.travel_20190313.City.Service.CityService;
import main.java.travel_20190313.Common.Business.Application.ServiceSupplier;
import main.java.travel_20190313.Common.Business.Application.StorageType;
import main.java.travel_20190313.Common.Business.Exceptions.BasicTravelCheckedException;
import main.java.travel_20190313.Common.Business.Exceptions.NeedToCancelOrderException;
import main.java.travel_20190313.Common.Business.Exceptions.NoSuchCityException;
import main.java.travel_20190313.Common.Business.Exceptions.NoSuchCountryException;
import main.java.travel_20190313.Common.Business.Service.SortType;
import main.java.travel_20190313.Country.Domain.Country;
import main.java.travel_20190313.Country.Service.CountryService;
import main.java.travel_20190313.Order.Domain.Order;
import main.java.travel_20190313.Order.Search.OrderSearchCondition;
import main.java.travel_20190313.Order.Service.OrderService;
import main.java.travel_20190313.User.Domain.SimpleUser;
import main.java.travel_20190313.User.Domain.User;
import main.java.travel_20190313.User.Domain.UserType;
import main.java.travel_20190313.User.Domain.VipUser;
import main.java.travel_20190313.User.Service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TravelDemo {

    private static ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

    private static CityService cityService = serviceSupplier.getCityService();
    private static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    public static UserService userService = ServiceSupplier.getInstance().getUserService();
    private static OrderService orderService = ServiceSupplier.getInstance().getOrderService();


    public static void main(String[] args) {
        CityMemoryListRepo cityRepo1 = new CityMemoryListRepo();
        City cc = cityRepo1.findById(8L);
        createNewCity("New-York");
        createNewCity("Los-Angeles");
        createNewCity("Southpark");
        createNewCity("Moscow");

        List<String> usaCitiList = new ArrayList<>();
        usaCitiList.add("New-York");
        usaCitiList.add("Los-Angeles");
        usaCitiList.add("Southpark");
        usaCitiList.add("Chicago");
        createNewCountry("USA", usaCitiList);

        createNewOrder("Ivan", "Ivanov", UserType.SIMPLE_USER, "444", "12547",
                500.0, "USA", Arrays.asList("New-York", "Los-Angeles"));

        createNewOrder("Masha", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                875.50, "USA", Arrays.asList("Kiev", "Livov", "Odessa"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                150000.0, "USA", Arrays.asList("Melburn"));

        cityService.printAll();
        countryService.printAll();
        orderService.printAll();

        createNewCountry("USA", Arrays.asList("New-York", "Los-Angeles"));//Country country1 = new Country("USA");//createNewOountry
        createNewCountry("Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));//Country country2 = new Country("Ukraine");
        createNewCountry("Russia", Arrays.asList("Moscow", "Spb", "Novosibirsk"));//Country country3 = new Country("Russia");

        OrderSearchCondition orderSearchCondition = new OrderSearchCondition("USA", SortType.DESC);
        List<Order> foundOrders = orderService.findByCondition(orderSearchCondition);

        for (Order order : foundOrders)
            System.out.println(order.getUser().getFirstName());

        try {
            cityService.deleteById(1L);
        } catch (NeedToCancelOrderException e) {
            for (Order cancelledOrder : e.getCancelledOrders()) {
                callUser(cancelledOrder.getUser().getPhoneNumber());
            }
        }

    }

    private static void createNewCity(String cityName) {
        try {
            cityService.add(new City(cityName));
        } catch (BasicTravelCheckedException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode().name());
        }
    }

    private static void createNewCountry(String countryName, List<String> cityList) {
        Country country = new Country("USA", "English");
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            cities.add(new City(cityList.get(i)));
        }
        country.setName(countryName);
        country.setCities(cities);
        try {
            countryService.add(country);
        } catch (BasicTravelCheckedException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode().name());
        }
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
        //user.setPassport(passportSerial, passportNumber);

        List<City> orderingCities = new ArrayList<>();

        for (String cityName : citiesNames) {
            orderingCities.add(new City(cityName));
        }

        List<Country> orderingCountry = new ArrayList<>();
        orderingCountry.add(new Country(countryName));
        orderingCountry.get(0).setCities(orderingCities);

        Order order = new Order(user, price, orderingCountry);
        try {
            orderService.add(order);
        } catch (BasicTravelCheckedException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode().name());
        }
    }

    public static void createNewUser() {
    }

    public static void callUser(String userPhoneNumber) {

    }
}
