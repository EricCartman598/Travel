package main.java.travel_20190303;


import main.java.travel_20190303.Common.Business.Service.SortType;
import main.java.travel_20190303.Order.Domain.Order;
import main.java.travel_20190303.Order.Search.OrderSearchCondition;
import main.java.travel_20190303.Order.Service.OrderService;
import main.java.travel_20190303.User.Domain.SimpleUser;
import main.java.travel_20190303.User.Domain.User;
import main.java.travel_20190303.User.Domain.UserType;
import main.java.travel_20190303.User.Domain.VipUser;
import main.java.travel_20190303.User.Service.UserService;
import main.java.travel_20190303.City.Domain.City;
import main.java.travel_20190303.City.Service.CityService;
import main.java.travel_20190303.Common.Business.Application.ServiceSupplier;
import main.java.travel_20190303.Common.Business.Application.StorageType;
import main.java.travel_20190303.Country.Domain.Country;
import main.java.travel_20190303.Country.Service.CountryService;


import java.util.*;


public class TravelDemo {

    public static ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

    public static CityService cityService = serviceSupplier.getCityService();
    public static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    public static UserService userService = ServiceSupplier.getInstance().getUserService();
    public static OrderService orderService = ServiceSupplier.getInstance().getOrderService();


    public static void main(String[] args) {

        createNewCity("New-York");
        createNewCity("Los-Angeles");
        createNewCity("Southpark");
        createNewCity("Moscow");

        List<String> usaCitiList = new ArrayList<>();
        usaCitiList.add("New-York");
        usaCitiList.add("Los-Angeles");
        usaCitiList.add("Southpark");
        usaCitiList.add("Chicago");
        createNewOountry("USA", usaCitiList);

        createNewOrder("Ivan", "Ivanov", UserType.SIMPLE_USER, "444", "12547",
                500.0, "USA", Arrays.asList("New-York", "Los-Angeles"));

        createNewOrder("Masha", "Ivanova", UserType.SIMPLE_USER, "555", "0014",
                875.50, "USA", Arrays.asList("Kiev", "Livov", "Odessa"));

        createNewOrder("Denis", "Ivanova", UserType.VIP_USER, "777", "789",
                150000.0, "USA", Arrays.asList("Melburn"));

        cityService.printAll();
        countryService.printAll();
        orderService.printAll();

        createNewOountry("USA", Arrays.asList("New-York", "Los-Angeles"));//Country country1 = new Country("USA");//createNewOountry
        createNewOountry("Ukraine", Arrays.asList("Kiev", "Livov", "Odessa"));//Country country2 = new Country("Ukraine");
        createNewOountry("Russia", Arrays.asList("Moscow", "Spb", "Novosibirsk"));//Country country3 = new Country("Russia");

        OrderSearchCondition orderSearchCondition = new OrderSearchCondition("USA", SortType.DESC);
        List<Order> foundOrders = orderService.findOrderByCondition(orderSearchCondition);

        for(Order order : foundOrders)
            System.out.println(order.getUser().getFirstName());

    }

    public static void createNewCity(String cityName) {
        cityService.addCity(new City(cityName));
    }

    public static void createNewOountry(String countryName, List<String> cityList) {
        Country country = new Country("USA", "English");
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            cities.add(new City(cityList.get(i)));
        }
        country.setName(countryName);
        country.setCities(cities);
        countryService.addCountry(country);
    }

    public static void createNewOrder(String userName, String userLastName, UserType userType,
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
        orderingCountry.add(new Country(countryName));//Country orderingCountry = new Country(countryName);
        orderingCountry.get(0).setCities(orderingCities);

        Order order = new Order(user, price, orderingCountry);
        orderService.addOrder(order);

    }


    public static void createNewUser() {

    }


}
