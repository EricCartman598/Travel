package main.java.travel_20190322.common.business.exceptions;

import main.java.travel_20190322.common.business.exceptions.BasicTravelCheckedException;
import main.java.travel_20190322.common.business.exceptions.ErrorCode;

public class NoSuchCountryException extends BasicTravelCheckedException {
    public NoSuchCountryException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_COUNTRY;
        this.message = "Desired country is not exists!";
    }
}
