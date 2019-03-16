package Travel_20190315.Country.LoadInitialData;

import Travel_20190315.City.Service.CityService;
import Travel_20190315.City.Service.Impl.CityMemoryListService;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Country.Service.CountryService;
import Travel_20190315.Country.Service.Impl.CountryMemoryListService;

import java.io.FileNotFoundException;

public interface ImportCountryInitialDataFromFile {

    void initCountryStorage(CountryService countryService, CityService cityService,
                            String filePath) throws FileNotFoundException;

    void initCityStorage(CityMemoryListService cityService, String filePath) throws FileNotFoundException;
}





