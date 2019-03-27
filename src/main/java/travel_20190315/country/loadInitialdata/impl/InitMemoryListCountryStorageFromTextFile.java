package main.java.travel_20190315.country.loadInitialdata.impl;

import main.java.travel_20190315.city.domain.City;
import main.java.travel_20190315.city.service.CityService;
import main.java.travel_20190315.city.service.impl.CityMemoryListService;
import main.java.travel_20190315.common.solution.dataclasses.Pair;
import main.java.travel_20190315.country.domain.BaseCountry;
import main.java.travel_20190315.country.domain.ColdCountry;
import main.java.travel_20190315.country.domain.CountryTemperatureType;
import main.java.travel_20190315.country.domain.HotCountry;


import main.java.travel_20190315.country.loadInitialdata.CountryDataFields;
import main.java.travel_20190315.country.loadInitialdata.ImportCountryInitialDataFromFile;
import main.java.travel_20190315.country.service.CountryService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class InitMemoryListCountryStorageFromTextFile implements ImportCountryInitialDataFromFile {
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
    public void initCountryStorage(CountryService countryService, CityService cityService,
                                   String filePath) throws FileNotFoundException {

        List<BaseCountry> countryList = parseFile(filePath);
        for (BaseCountry country : countryList) {
            countryService.add(country);
            //for(city city : country.getCities())
            //    cityService.add(city);
        }
    }

    @Override
    public void initCityStorage(CityMemoryListService cityService, String filePath) throws FileNotFoundException {

    }

    private void fillCountryField(Pair countryParams) {

        switch (countryParams.getLeft().toLowerCase()) {
            case CountryDataFields.COUNTRY:
                name = countryParams.getRight();
                //country.setName(countryParams.getRight());
                break;
            case CountryDataFields.LANGUAGE:
                language = countryParams.getRight();
                //country.setLanguage(countryParams.getRight());
                break;
            case CountryDataFields.CITIES:
                cityNames = countryParams.getRight().split(",");
                //for (String cityName : cityNames)
                //    country.getCities().add(new City(cityName.trim()));
                break;
            case CountryDataFields.DISCRIMINATOR:
                switch (countryParams.getRight().toLowerCase()) {
                    case CountryDataFields.COLD:
                        discriminator = CountryTemperatureType.COLD;
                        //country.setDiscriminator(CountryTemperatureType.COLD);
                        break;
                    case CountryDataFields.HOT:
                        discriminator = CountryTemperatureType.HOT;
                        //country.setDiscriminator(CountryTemperatureType.HOT);
                        break;
                }
                break;
            case CountryDataFields.HOTEST_MONTH:
                hotestMonth = countryParams.getRight();
                break;
            case CountryDataFields.TELEPHONE_CODE:
                telephoneCode = countryParams.getRight();
                break;
            case CountryDataFields.IS_POLAR_NIGHT:
                isPolarNight = countryParams.getRight().equals(CountryDataFields.YES);
                break;
            case CountryDataFields.AVERAGE_TEMPERATURE:
                averageTemperature = Double.parseDouble(countryParams.getRight());
                break;
            default:
                break;
        }
    }

    private BaseCountry createCountry() {
        BaseCountry baseCoutnry = null;
        switch (discriminator) {
            case COLD:
                baseCoutnry = new ColdCountry(name, language, telephoneCode, isPolarNight);
                baseCoutnry.setDiscriminator(discriminator);
                for (String cityName : cityNames)
                    baseCoutnry.getCities().add(new City(cityName.trim()));
                break;
            case HOT:
                baseCoutnry = new HotCountry(name, language, hotestMonth, averageTemperature);
                baseCoutnry.setDiscriminator(discriminator);
                for (String cityName : cityNames)
                    baseCoutnry.getCities().add(new City(cityName.trim()));
                break;
        }

        return baseCoutnry;
    }

    private List<BaseCountry> parseFile(String filePath) throws FileNotFoundException {
        List<BaseCountry> importedCountries = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = null;

            //Country country = new Country();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(CountryDataFields.EMPTY_STRING)) {
                    importedCountries.add(createCountry());
                    //country = new Country();
                    continue;
                }

                String[] lines = line.split(":");
                if (lines.length != 2)
                    continue;

                fillCountryField(new Pair(lines[0].trim(), lines[1].trim()));
                //Pair countryParams = new Pair(lines[0].trim(), lines[1].trim());

            }



            importedCountries.add(createCountry());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return importedCountries;
    }

}


