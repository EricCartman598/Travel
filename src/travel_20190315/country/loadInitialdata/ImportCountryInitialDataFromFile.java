package travel_20190315.country.loadInitialdata;

import travel_20190315.city.service.CityService;
import travel_20190315.city.service.impl.CityMemoryListService;
import travel_20190315.country.service.CountryService;

import java.io.FileNotFoundException;

public interface ImportCountryInitialDataFromFile {

    void initCountryStorage(CountryService countryService, CityService cityService,
                            String filePath) throws FileNotFoundException;

    void initCityStorage(CityMemoryListService cityService, String filePath) throws FileNotFoundException;
}





