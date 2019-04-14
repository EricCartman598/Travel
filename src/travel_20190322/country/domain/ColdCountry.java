package main.java.travel_20190322.country.domain;

import main.java.travel_20190322.country.domain.BaseCountry;

import javax.xml.bind.annotation.XmlElement;

public class ColdCountry extends BaseCountry {

    //@XmlElement(name = "telephone_code")
    private String telephoneCode;
    //@XmlElement(name = "is_polar_night")
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

    //@XmlElement(name = "telephoneCode")
    public void setTelephoneCode(String telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public boolean isPolarNight() {
        return isPolarNight;
    }

    //@XmlElement(name = "isPolarNight")
    public void setPolarNight(boolean polarNight) {
        isPolarNight = polarNight;
    }
}
