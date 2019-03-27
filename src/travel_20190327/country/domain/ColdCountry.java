package travel_20190327.country.domain;

import travel_20190327.country.domain.BaseCountry;

import javax.xml.bind.annotation.XmlElement;

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
