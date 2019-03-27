package travel_20190327.common.business.exceptions;

import travel_20190327.common.business.exceptions.BasicTravelCheckedException;
import travel_20190327.common.business.exceptions.ErrorCode;

public class CannotDeleteCityException extends BasicTravelCheckedException {
    public CannotDeleteCityException() {
        super();
        this.errorCode = ErrorCode.CANNOT_DELETE_CITY;
        this.message = "Removing city is incuded in orders!";
    }
}
