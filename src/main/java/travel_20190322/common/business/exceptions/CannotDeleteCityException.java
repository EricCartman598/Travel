package main.java.travel_20190322.common.business.exceptions;

public class CannotDeleteCityException extends BasicTravelCheckedException {
    public CannotDeleteCityException() {
        super();
        this.errorCode = ErrorCode.CANNOT_DELETE_CITY;
        this.message = "Removing city is incuded in orders!";
    }
}
