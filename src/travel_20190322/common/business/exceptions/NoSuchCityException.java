package main.java.travel_20190322.common.business.exceptions;

import main.java.travel_20190322.common.business.exceptions.BasicTravelCheckedException;
import main.java.travel_20190322.common.business.exceptions.ErrorCode;

public class NoSuchCityException extends BasicTravelCheckedException {
    public NoSuchCityException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_CITY;
        this.message = "Desired city is not exists!";
    }
}
