package travel_20190406.city.dto;

import travel_20190406.city.domain.City;
import travel_20190406.common.business.domain.BaseDomain;
import travel_20190406.common.business.dto.BaseDomainDto;

import java.util.Objects;

public class CityDto  extends BaseDomainDto<Long> {
    private String name;
    private int population;
    private boolean isCapital;
    /*Climate climate;

    public enum Climate {
        TROPIC,
        SUB_TROPIC,
        CONTINENTAL,
        ARCTIC,
        OTHER
    }*/

    public CityDto() {

    }

    public CityDto(String name) {
        super();
        this.name = name;
    }

    public CityDto(String name, int population, boolean isCapital) {
        super();
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return population == cityDto.population &&
                isCapital == cityDto.isCapital &&
                name.equals(cityDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, isCapital);
    }
}
