package travel_20190322.storage.loadinitialdata;

import travel_20190322.city.domain.City;
import travel_20190322.country.domain.BaseCountry;
import travel_20190322.country.service.CountryService;
import travel_20190322.storage.Storage;
import travel_20190322.storage.loadinitialdata.ImportDataFromFile;
import travel_20190322.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromTextFile;
import travel_20190322.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromXmlFile;

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
