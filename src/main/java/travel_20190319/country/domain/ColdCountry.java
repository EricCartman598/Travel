package main.java.travel_20190319.country.domain;

import main.java.travel_20190319.country.domain.BaseCountry;

public class ColdCountry extends BaseCountry {

    private String telephoneCode;
    private boolean isPolarNight;

    public ColdCountry()  {

    }

    public ColdCountry(String name) {
        super(name);
    }

    public ColdCountry(String name, String language) {
        super(name, language);
    }

    public ColdCountry(String name, String telephoneCode, boolean isPolarNight) {
        super(name);
        this.telephoneCode = telephoneCode;
        this.isPolarNight = isPolarNight;
    }

    public ColdCountry(String name, String language, String telephoneCode, boolean isPolarNight) {
        super(name, language);
        this.telephoneCode = telephoneCode;
        this.isPolarNight = isPolarNight;
    }

    public String getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(String telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public boolean isPolarNight() {
        return isPolarNight;
    }

    public void setPolarNight(boolean polarNight) {
        isPolarNight = polarNight;
    }
}
