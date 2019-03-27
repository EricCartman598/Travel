package main.java.travel_20190315.country.domain;

import main.java.travel_20190315.common.business.domain.Month;

public class HotCountry extends BaseCountry {

    private String hotestMonth;
    private Double averageTemperature;

    public HotCountry(String name) {
        super(name);
    }

    public HotCountry(String name, String language) {
        super(name, language);
    }

    public HotCountry(String name, String hotestMonth, Double averageTemperature) {
        super(name);
        this.hotestMonth = hotestMonth;
        this.averageTemperature = averageTemperature;
    }

    public HotCountry(String name, String language, String hotestMonth, Double averageTemperature) {
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
