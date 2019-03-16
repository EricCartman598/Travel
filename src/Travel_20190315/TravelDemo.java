package Travel_20190315;


import Travel_20190315.City.Domain.City;
import Travel_20190315.City.Service.CityService;
import Travel_20190315.Common.Business.Application.ServiceSupplier;
import Travel_20190315.Common.Business.Application.StorageType;
import Travel_20190315.Common.Business.Exceptions.NeedToCancelOrderException;
import Travel_20190315.Common.Business.Service.SortType;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Country.LoadInitialData.Impl.InitMemoryListCountryStorageFromTextFile;
import Travel_20190315.Country.LoadInitialData.ImportCountryInitialDataFromFile;
import Travel_20190315.Country.Service.CountryService;
import Travel_20190315.Order.Domain.Order;
import Travel_20190315.Order.Search.OrderSearchCondition;
import Travel_20190315.Order.Service.OrderService;
import Travel_20190315.Reporting.ExportData;
import Travel_20190315.Reporting.Impl.ExportDataToTxtFile;
import Travel_20190315.User.Domain.SimpleUser;
import Travel_20190315.User.Domain.User;
import Travel_20190315.User.Domain.UserType;
import Travel_20190315.User.Domain.VipUser;
import Travel_20190315.User.Service.UserService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Travel_20190315.Storage.Storage.cities;
import static Travel_20190315.Storage.Storage.orders;


public class TravelDemo {

    private static ServiceSupplier serviceSupplier = ServiceSupplier.newInstance(StorageType.MEMORY_LIST);

    private static CityService cityService = serviceSupplier.getCityService();
    private static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    public static UserService userService = ServiceSupplier.getInstance().getUserService();
    private static OrderService orderService = ServiceSupplier.getInstance().getOrderService();


    public static void main(String[] args) {

        try {
            ImportCountryInitialDataFromFile importData = new InitMemoryListCountryStorageFromTextFile();
            importData.initCountryStorage(countryService, cityService, "D:\\countries.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error while file reading!");
        }

        cityService.printAll();

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
        //user.setPassport(passportSerial, passportNumber);

        List<City> orderingCities = new ArrayList<>();

        for (String cityName : citiesNames) {
            orderingCities.add(new City(cityName));
        }

        List<BaseCountry> orderingCountry = new ArrayList<>();
        orderingCountry.add(new BaseCountry(countryName));
        orderingCountry.get(0).setCities(orderingCities);

        Order order = new Order(user, price, orderingCountry);
        orderService.add(order);
    }

    public static void createNewUser() {
    }

    private static void callUser(String userName, String userPhoneNumber) {
        System.out.println("call user " + userName + " with phone number " + userPhoneNumber);
    }
}
