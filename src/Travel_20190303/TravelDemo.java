package Travel_20190303;



import Travel_20190303.Order.Service.OrderService;
import Travel_20190303.User.Service.UserService;
import Travel_20190303.City.Domain.City;
import Travel_20190303.City.Service.CityService;
import Travel_20190303.Common.Business.Application.ServiceSupplier;
import Travel_20190303.Common.Business.Application.StorageType;
import Travel_20190303.Country.Domain.Country;
import Travel_20190303.Country.Service.CountryService;


import java.util.ArrayList;
import java.util.List;


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

        cityService.printAll();
        countryService.printAll();

    }

    public static void createNewCity(String cityName) {
        cityService.addCity(new City(cityName));
    }

    public static void createNewOountry(String countryName, List<String> cityList) {
        Country country = new Country("USA", "English");
        List<City> cities = new ArrayList<>();
        for(int i = 0; i < cityList.size(); i++) {
            cities.add(new City(cityList.get(i)));
        }
        country.setName(countryName);
        country.setCities(cities);
        countryService.addCountry(country);
    }

    public static  void createNewOrder() {

    }

    public static void createNewUser() {

    }


}
