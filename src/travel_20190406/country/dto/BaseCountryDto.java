package travel_20190406.country.dto;

import travel_20190406.city.domain.City;
import travel_20190406.city.dto.CityDto;
import travel_20190406.common.business.domain.BaseDomain;
import travel_20190406.common.business.dto.BaseDomainDto;
import travel_20190406.country.domain.CountryTemperatureType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseCountryDto extends BaseDomainDto<Long> {
    protected String name;
    protected String language;
    protected List<CityDto> cities = new ArrayList<>();
    protected CountryTemperatureType discriminator;

    public BaseCountryDto() {

    }

    public BaseCountryDto(String name) {
        this.name = name;
        this.language = null;
        //this.cities = null;
    }

    public BaseCountryDto(String name, String language) {
        super();
        this.name = name;
        this.language = language;
        //this.cities = null;
    }

    public BaseCountryDto(String name, List<CityDto> cities) {
        this.name = name;
        this.cities = cities;
    }

    public CountryTemperatureType getDiscriminator() {
        return discriminator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    public void setDiscriminator(CountryTemperatureType discriminator) {
        this.discriminator = discriminator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCountryDto country = (BaseCountryDto) o;
        return name.equals(country.name);/* &&
                language.equals(country.language) &&
                cities.equals(country.cities);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, cities);
    }
}
