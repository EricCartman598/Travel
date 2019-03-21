package travel_20190319.storage.loadinitialdata.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import travel_20190319.city.domain.City;

import travel_20190319.country.domain.BaseCountry;
import travel_20190319.country.domain.ColdCountry;
import travel_20190319.country.domain.CountryTemperatureType;
import travel_20190319.country.domain.HotCountry;
import travel_20190319.storage.loadinitialdata.CountryDataFields;
import travel_20190319.storage.loadinitialdata.ImportDataFromFile;

import java.util.ArrayList;
import java.util.List;


public class InitMemoryListCountryStorageFromXmlFile implements ImportDataFromFile<List<BaseCountry>> {

    @Override
    public List<BaseCountry> getDataFromFile(String filePath) throws Exception {
        return parseFile(filePath);
    }

    private List<BaseCountry> parseFile(String filePath) throws Exception {

        List<BaseCountry> importedCountries = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(filePath));

        Node root = doc.getElementsByTagName(CountryDataFields.COUNTRIES).item(0);
        NodeList countryList = ((Element) root).getElementsByTagName(CountryDataFields.COUNTRY);

        if(countryList.getLength() == 0)
            return null;

        importedCountries = new ArrayList<>();
        for (int i = 0; i < countryList.getLength(); i++) {
            Node country = countryList.item(i);
            BaseCountry importedCountry = null;
            NodeList countryInnerTags = country.getChildNodes();

            if(countryInnerTags.getLength() == 0)
                return null;

            switch(((Element)country).getAttribute(CountryDataFields.DISCRIMINATOR)) {
                case CountryDataFields.HOT:
                    importedCountry = new HotCountry();
                    importedCountry.setDiscriminator(CountryTemperatureType.HOT);
                    break;
                case CountryDataFields.COLD:
                    importedCountry = new ColdCountry();
                    importedCountry.setDiscriminator(CountryTemperatureType.COLD);
                    break;
            }

            for (int j = 0; j < countryInnerTags.getLength(); j++) {
                Node countryInner = countryInnerTags.item(j);
                switch (countryInner.getNodeName()) {

                    case CountryDataFields.COUNTRY_NAME:
                        importedCountry.setName(countryInner.getTextContent().trim());
                        break;
                    case CountryDataFields.LANGUAGE:
                        importedCountry.setLanguage(countryInner.getTextContent().trim());
                        break;
                    case CountryDataFields.CITIES:
                        NodeList cityList = ((Element) countryInner).getElementsByTagName(CountryDataFields.CITY);
                        for (int k = 0; k < cityList.getLength(); k++) {
                            City importedCity = new City(cityList.item(k).getTextContent().trim());
                            importedCountry.getCities().add(importedCity);
                        }
                        break;
                    case CountryDataFields.IS_POLAR_NIGHT:
                        if (countryInner.getTextContent().equals(CountryDataFields.YES))
                            ((ColdCountry)importedCountry).setPolarNight(true);
                        else
                            ((ColdCountry)importedCountry).setPolarNight(false);
                        break;
                    case CountryDataFields.TELEPHONE_CODE:
                        ((ColdCountry)importedCountry).setTelephoneCode(countryInner.getTextContent().trim());
                        break;
                    case CountryDataFields.HOTEST_MONTH:
                        ((HotCountry)importedCountry).setHotestMonth(countryInner.getTextContent().trim());
                        break;
                    case CountryDataFields.AVERAGE_TEMPERATURE:
                        ((HotCountry)importedCountry).setAverageTemperature(Double.parseDouble(countryInner.getTextContent()));
                        break;
                }
            }
            importedCountries.add(importedCountry);
        }

        return importedCountries;
    }
}


