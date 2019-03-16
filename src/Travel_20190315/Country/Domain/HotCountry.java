package Travel_20190315.Country.Domain;

import Travel_20190315.Common.Business.Domain.Month;

public class HotCountry extends BaseCountry {

    private Month hotestMonth;
    private Double averageTemperature;

    public HotCountry(String name) {
        super(name);
    }

    public HotCountry(String name, String language) {
        super(name, language);
    }

    public HotCountry(String name, Month hotestMonth, Double averageTemperature) {
        super(name);
        this.hotestMonth = hotestMonth;
        this.averageTemperature = averageTemperature;
    }

    public HotCountry(String name, String language, Month hotestMonth, Double averageTemperature) {
        super(name, language);
        this.hotestMonth = hotestMonth;
        this.averageTemperature = averageTemperature;
    }

    public Month getHotestMonth() {
        return hotestMonth;
    }

    public void setHotestMonth(Month hotestMonth) {
        this.hotestMonth = hotestMonth;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
}
