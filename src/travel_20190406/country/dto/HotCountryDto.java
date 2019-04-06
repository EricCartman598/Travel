package travel_20190406.country.dto;

import travel_20190406.country.domain.BaseCountry;

public class HotCountryDto extends BaseCountryDto {

    private String hotestMonth;
    private Double averageTemperature;

    public HotCountryDto()  {

    }

    public HotCountryDto(String name) {
        super(name);
    }

    public HotCountryDto(String name, String language) {
        super(name, language);
    }

    public HotCountryDto(String name, String hotestMonth, Double averageTemperature) {
        super(name);
        this.hotestMonth = hotestMonth;
        this.averageTemperature = averageTemperature;
    }

    public HotCountryDto(String name, String language, String hotestMonth, Double averageTemperature) {
        super(name, language);
        this.hotestMonth = hotestMonth;
        this.averageTemperature = averageTemperature;
    }

    public String getHotestMonth() {
        return hotestMonth;
    }

    public void setHotestMonth(String hotestMonth) {
        this.hotestMonth = hotestMonth;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
}
