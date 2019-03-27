package main.java.travel_20190224;

import main.java.travel_20190224.City.City;
import main.java.travel_20190224.City.Service.CityMemoryService;

public class TravelDemo {
    private String cityName;
    private Long cityId;

    public City searchCity(String name, Long id) {

        cityId = id;
        cityName = name;
        return getCity(new CrudInterface() {
            @Override
            public void add() {

            }

            @Override
            public Object find() {
                if (cityId != null)
                    return new CityMemoryService().findCityById(cityId);
                else if (!cityName.trim().isEmpty())
                    return new CityMemoryService().findCityByName(cityName);
                return null;
            }

            @Override
            public void delete() {

            }
        });
    }


    private City getCity(CrudInterface crudInterface) {
        return (City) crudInterface.find();
    }

}
