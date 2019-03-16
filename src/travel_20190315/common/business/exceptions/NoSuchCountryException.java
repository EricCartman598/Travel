package travel_20190315.common.business.exceptions;

public class NoSuchCountryException extends BasicTravelCheckedException {
    public NoSuchCountryException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_COUNTRY;
        this.message = "Desired country is not exists!";
    }
}
