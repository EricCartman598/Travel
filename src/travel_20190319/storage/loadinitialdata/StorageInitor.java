package main.java.travel_20190319.storage.loadinitialdata;

import main.java.travel_20190319.city.domain.City;
import main.java.travel_20190319.country.domain.BaseCountry;
import main.java.travel_20190319.country.service.CountryService;
import main.java.travel_20190319.storage.Storage;
import main.java.travel_20190319.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromTextFile;
import main.java.travel_20190319.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromXmlFile;

import java.util.List;

public class StorageInitor {

    public enum DataSourceType {
        TXT_FILE,
        XML_FILE,
        JSON_FILE
    }

    public void initCountryStorageFromFile(CountryService countryService, String filePath, DataSourceType sourceType) throws Exception {
        ImportDataFromFile<List<BaseCountry>> importer = null;
        switch(sourceType) {
            case TXT_FILE:
                importer = new InitMemoryListCountryStorageFromTextFile();
                break;
            case XML_FILE:
                importer = new InitMemoryListCountryStorageFromXmlFile();
                break;
        }

        if(importer != null) {
            List<BaseCountry> importedCountries = importer.getDataFromFile(filePath);
            for(BaseCountry country : importedCountries)
            countryService.add(country);
        }
    }
}
