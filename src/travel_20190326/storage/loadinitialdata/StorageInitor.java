package travel_20190326.storage.loadinitialdata;

import travel_20190326.country.domain.BaseCountry;
import travel_20190326.country.service.CountryService;
import travel_20190326.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromTextFile;
import travel_20190326.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromXmlFile;
import travel_20190326.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromXmlJAXB;
import travel_20190326.storage.loadinitialdata.impl.ThreadInitData;

import java.util.List;

public class StorageInitor {

    private boolean useJAXB;

    public StorageInitor(boolean useJAXB) {
        this.useJAXB = useJAXB;
    }

    public enum DataSourceType {
        TXT_FILE,
        XML_FILE,
        JSON_FILE
    }

    public void initCountryStorageFromFile(CountryService countryService, String filePath, DataSourceType sourceType) throws Exception {
        ImportDataFromFile<List<BaseCountry>> importer = null;
        if (useJAXB)
            importer = new InitMemoryListCountryStorageFromXmlJAXB();
        else {
            switch (sourceType) {
                case TXT_FILE:
                    importer = new InitMemoryListCountryStorageFromTextFile();
                    break;
                case XML_FILE:
                    importer = new InitMemoryListCountryStorageFromXmlFile();
                    break;
            }
        }

        if (importer != null) {
            List<BaseCountry> importedCountries = importer.getDataFromFile(filePath);
            for (BaseCountry country : importedCountries)
                countryService.add(country);
        }
    }
}


