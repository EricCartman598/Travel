package Travel_20190313.Common.Business.Exceptions;

public class NoSuchCityException extends BasicTravelCheckedException {
    public NoSuchCityException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_CITY;
        this.message = "Desired city is not exists!";
    }
}
