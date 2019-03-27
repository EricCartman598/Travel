package main.java.travel_20190315.common.business.exceptions;

public class NoSuchCityException extends BasicTravelCheckedException {
    public NoSuchCityException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_CITY;
        this.message = "Desired city is not exists!";
    }
}
