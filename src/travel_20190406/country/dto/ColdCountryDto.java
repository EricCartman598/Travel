package travel_20190406.country.dto;

public class ColdCountryDto extends BaseCountryDto {
    private String telephoneCode;
    private boolean isPolarNight;

    public ColdCountryDto()  {

    }

    public ColdCountryDto(String name) {
        super(name);
    }

    public ColdCountryDto(String name, String language) {
        super(name, language);
    }

    public ColdCountryDto(String name, String telephoneCode, boolean isPolarNight) {
        super(name);
        this.telephoneCode = telephoneCode;
        this.isPolarNight = isPolarNight;
    }

    public ColdCountryDto(String name, String language, String telephoneCode, boolean isPolarNight) {
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
