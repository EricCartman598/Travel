package travel_20190327.storage.loadinitialdata;

import travel_20190327.country.domain.BaseCountry;
import travel_20190327.country.service.CountryService;
import travel_20190327.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromTextFile;
import travel_20190327.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromXmlFile;
import travel_20190327.storage.loadinitialdata.impl.InitMemoryListCountryStorageFromXmlJAXB;
import travel_20190327.storage.loadinitialdata.impl.ThreadInitData;

import java.util.ArrayList;
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

    public ImportDataFromFile<List<BaseCountry>> getCountryImporter(DataSourceType sourceType) {
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
        return importer;
    }

    public void initCountryStorageFromFile(ImportDataFromFile<List<BaseCountry>> importer, CountryService countryService, String... filePath) throws Exception {
        if (importer != null) {
            List<BaseCountry> importedCountries = multithreadGetDataFromFiles(importer, filePath);
            for (BaseCountry country : importedCountries)
                countryService.add(country);
        }
    }

    public void initCountryStorageFromFile(ImportDataFromFile<List<BaseCountry>> importer, CountryService countryService, String filePath) throws Exception {
        if (importer != null) {
            List<BaseCountry> importedCountries = importer.getDataFromFile(filePath);
            for (BaseCountry country : importedCountries)
                countryService.add(country);
        }
    }

    private List<BaseCountry> multithreadGetDataFromFiles(ImportDataFromFile<List<BaseCountry>> importer, String... files) {

        List<BaseCountry> dataFromFiles = new ArrayList<>();
        List<ThreadInitData> readThreadsList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            readThreadsList.add(new ThreadInitData(files[i], importer));
        }

        for (int i = 0; i < readThreadsList.size(); i++) {
            try {
                readThreadsList.get(i).getThread().join();
                dataFromFiles.addAll(readThreadsList.get(i).getCountriesList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return dataFromFiles;
    }
}


