package travel_20190406.storage.loadinitialdata.impl;

import travel_20190406.country.domain.BaseCountry;
import travel_20190406.country.domain.ColdCountry;
import travel_20190406.country.domain.CountryTemperatureType;
import travel_20190406.country.domain.HotCountry;
import travel_20190406.storage.loadinitialdata.ImportDataFromFile;
import travel_20190406.storage.loadinitialdata.xjc.City;
import travel_20190406.storage.loadinitialdata.xjc.Country;
import travel_20190406.storage.loadinitialdata.xjc.InitData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InitMemoryListCountryStorageFromXmlJAXB implements ImportDataFromFile<List<BaseCountry>> {
    @Override
    public List<BaseCountry> getDataFromFile(String filePath) throws Exception {
        InitData initData = readDataFromXmlWithJaxbString(filePath);
        return convertJaxbClassesToDomainClasses(initData);
    }

    private InitData readDataFromXmlWithJaxbString(String xmlFilePath) throws Exception {
        JAXBContext context = JAXBContext.newInstance(InitData.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (InitData) unmarshaller.unmarshal(new File(xmlFilePath));
    }

    private List<BaseCountry> convertJaxbClassesToDomainClasses(InitData initData) {
        List<BaseCountry> baseCountries = new ArrayList<>();

        for (Country country : initData.getCountries().getCountry()) {
            BaseCountry baseCountry = null;//new BaseCountry();

            switch (country.getDiscriminator()) {
                case HOT:
                    baseCountry = new HotCountry();
                    baseCountry.setDiscriminator(CountryTemperatureType.HOT);
                    ((HotCountry) baseCountry).setHotestMonth(country.getHotestMonth());
                    ((HotCountry) baseCountry).setAverageTemperature(Double.parseDouble(country.getAverageTemperature()));
                    break;
                case COLD:
                    baseCountry = new ColdCountry();
                    baseCountry.setDiscriminator(CountryTemperatureType.COLD);
                    ((ColdCountry) baseCountry).setPolarNight(Boolean.parseBoolean(country.getIsPolarNight()));
                    ((ColdCountry) baseCountry).setTelephoneCode(country.getTelephoneCode());
                    break;
            }
            baseCountry.setName(country.getName());
            baseCountry.setLanguage(country.getLanguage());
            for(City city : country.getCities().getCity()) {
                travel_20190406.city.domain.City importedCity = new travel_20190406.city.domain.City();
                importedCity.setName(city.getName());
                importedCity.setPopulation(city.getPopulation());
                importedCity.setCapital(city.isIsCapital());
                baseCountry.getCities().add(importedCity);
            }
            baseCountries.add(baseCountry);
        }
        return baseCountries;
    }
}
