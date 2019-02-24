package Travel_20190224;

import Travel_20190224.City.City;
import Travel_20190224.City.Service.CityMemoryService;

public class TravelDemo {
    private String cityName;
    private Long cityId;

    public City searchCity(String name, Long id) {
        if (id != null) {
            cityId = id;
            getCity(new CrudInterface() {
                @Override
                public void add() {

                }

                @Override
                public Object find() {
                    return new CityMemoryService().findCityById(cityId);
                }

                @Override
                public void delete() {

                }
            });
        } else if (name.trim().isEmpty()) {
            cityName = name;
            return getCity(new CrudInterface() {
                @Override
                public void add() {

                }

                @Override
                public Object find() {
                    return new CityMemoryService().findCityByName(cityName);
                }

                @Override
                public void delete() {

                }
            });
        }

        return null;
    }


    public City getCity(CrudInterface crudInterface) {
        return (City) crudInterface.find();
    }

}
