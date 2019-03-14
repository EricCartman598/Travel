package Travel_20190313.Common.Business.Exceptions;

public class NoSuchCountryException extends BasicTravelCheckedException {
    public NoSuchCountryException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_COUNTRY;
        this.message = "Desired country is not exists!";
    }
}
