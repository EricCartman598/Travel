package travel_20190322.storage.loadinitialdata.impl;

import travel_20190322.city.domain.City;
import travel_20190322.city.service.CityService;
import travel_20190322.common.solution.dataclasses.Pair;
import travel_20190322.country.domain.BaseCountry;
import travel_20190322.country.domain.ColdCountry;
import travel_20190322.country.domain.CountryTemperatureType;
import travel_20190322.country.domain.HotCountry;


import travel_20190322.country.service.CountryService;
import travel_20190322.storage.loadinitialdata.CountryDataFields;
import travel_20190322.storage.loadinitialdata.ImportDataFromFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class InitMemoryListCountryStorageFromTextFile implements ImportDataFromFile<List<BaseCountry>> {
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
    public List<BaseCountry> getDataFromFile(String filePath) throws Exception {
        List<BaseCountry> countryList = parseFile(filePath);

        return countryList;
    }

    private void fillCountryField(Pair countryParams) {

        switch (countryParams.getLeft().toLowerCase()) {
            case CountryDataFields.COUNTRY:
                name = countryParams.getRight();
                //baseCountry.setName(countryParams.getRight());
                break;
            case CountryDataFields.LANGUAGE:
                language = countryParams.getRight();
                //baseCountry.setLanguage(countryParams.getRight());
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
                        //baseCountry.setDiscriminator(CountryTemperatureType.COLD);
                        break;
                    case CountryDataFields.HOT:
                        discriminator = CountryTemperatureType.HOT;
                        //baseCountry.setDiscriminator(CountryTemperatureType.HOT);
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

            //BaseCountry baseCountry = new BaseCountry();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(CountryDataFields.EMPTY_STRING)) {
                    importedCountries.add(createCountry());
                    //baseCountry = new BaseCountry();
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


