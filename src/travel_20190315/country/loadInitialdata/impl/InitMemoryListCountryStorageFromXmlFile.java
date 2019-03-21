package travel_20190315.country.loadInitialdata.impl;

import travel_20190315.city.service.CityService;
import travel_20190315.city.service.impl.CityMemoryListService;
import travel_20190315.country.domain.BaseCountry;
import travel_20190315.country.domain.ColdCountry;
import travel_20190315.country.domain.CountryTemperatureType;
import travel_20190315.country.domain.HotCountry;
import travel_20190315.country.loadInitialdata.ImportCountryInitialDataFromFile;
import travel_20190315.country.service.CountryService;

import java.io.FileNotFoundException;
import java.util.List;

public class InitMemoryListCountryStorageFromXmlFile implements ImportCountryInitialDataFromFile {
    private String hotestMonth;
    private Double averageTemperature;
    private String telephoneCode;
    private boolean isPolarNight;
    private String[] cityNames;
    private String name;
    private String language;
    private CountryTemperatureType discriminator;
    ColdCountry coldCountry = new ColdCountry("");
    HotCountry hotCountry = new HotCountry("");

    @Override
    public void initCountryStorage(CountryService countryService, CityService cityService, String filePath) throws FileNotFoundException {
        /*List<BaseCountry> countryList = parseFile(filePath);
        for (BaseCountry country : countryList) {
            countryService.add(country);
            //for(city city : country.getCities())
            //    cityService.add(city);
        }*/
    }

    @Override
    public void initCityStorage(CityMemoryListService cityService, String filePath) throws FileNotFoundException {

    }
}
