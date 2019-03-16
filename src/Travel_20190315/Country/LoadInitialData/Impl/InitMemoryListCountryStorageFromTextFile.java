package Travel_20190315.Country.LoadInitialData.Impl;

import Travel_20190315.City.Domain.City;
import Travel_20190315.City.Service.CityService;
import Travel_20190315.City.Service.Impl.CityMemoryListService;
import Travel_20190315.Common.Solution.DataClasses.Pair;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Country.Domain.CountryTemperatureType;
import Travel_20190315.Country.LoadInitialData.ImportCountryInitialDataFromFile;
import Travel_20190315.Country.Service.CountryService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InitMemoryListCountryStorageFromTextFile implements ImportCountryInitialDataFromFile {

    @Override
    public void initCountryStorage(CountryService countryService, CityService cityService,
                                   String filePath) throws FileNotFoundException {

        List<BaseCountry> countryList = parseFile(filePath);
        for(BaseCountry country : countryList) {
            countryService.add(country);
            //for(City city : country.getCities())
            //    cityService.add(city);
        }
    }

    @Override
    public void initCityStorage(CityMemoryListService cityService, String filePath) throws FileNotFoundException {

    }

    private void fillCountryField(Pair countryParams, BaseCountry baseCountry) {
        switch (countryParams.getLeft().toLowerCase()) {
            case CountryDataFields.COUNTRY:
                baseCountry.setName(countryParams.getRight());
                break;
            case CountryDataFields.LANGUAGE:
                baseCountry.setLanguage(countryParams.getRight());
                break;
            case CountryDataFields.CITIES:
                String[] cityNames = countryParams.getRight().split(",");
                for (String cityName : cityNames)
                    baseCountry.getCities().add(new City(cityName.trim()));
                break;
            case CountryDataFields.DISCRIMINATOR:
                switch (countryParams.getRight().toLowerCase()) {
                    case CountryDataFields.COLD:
                        baseCountry.setDiscriminator(CountryTemperatureType.COLD);
                        break;
                    case CountryDataFields.HOT:
                        baseCountry.setDiscriminator(CountryTemperatureType.HOT);
                        break;
                }
                break;
                    /*case CountryDataFields.EMPTY_STRING:
                        importedCountries.add(baseCountry);
                        break;*/
            default:
                break;
        }

                /*switch (baseCountry.getDiscriminator()) {
                    case COLD:
                        break;
                    case HOT:
                        break;
                }*/
    }

    private List<BaseCountry> parseFile(String filePath) throws FileNotFoundException {
        List<BaseCountry> importedCountries = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = null;

            BaseCountry baseCountry = new BaseCountry();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(CountryDataFields.EMPTY_STRING)) {
                    importedCountries.add(baseCountry);
                    baseCountry = new BaseCountry();
                    continue;
                }

                String[] lines = line.split(":");
                if (lines.length != 2)
                    continue;

                fillCountryField(new Pair(lines[0].trim(), lines[1].trim()), baseCountry);
                //Pair countryParams = new Pair(lines[0].trim(), lines[1].trim());

            }
            importedCountries.add(baseCountry);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return importedCountries;
    }

}


