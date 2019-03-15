package Travel_20190315.Country.Domain;

public class ColdCountry extends BaseCountry {

    private String telephoneCold;
    private boolean isPolarNight;

    public ColdCountry(String name) {
        super(name);
    }

    public ColdCountry(String name, String language) {
        super(name, language);
    }

    public ColdCountry(String name, String telephoneCold, boolean isPolarNight) {
        super(name);
        this.telephoneCold = telephoneCold;
        this.isPolarNight = isPolarNight;
    }

    public ColdCountry(String name, String language, String telephoneCold, boolean isPolarNight) {
        super(name, language);
        this.telephoneCold = telephoneCold;
        this.isPolarNight = isPolarNight;
    }
}
