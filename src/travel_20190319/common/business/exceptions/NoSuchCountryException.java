package travel_20190319.common.business.exceptions;

import travel_20190319.common.business.exceptions.BasicTravelCheckedException;
import travel_20190319.common.business.exceptions.ErrorCode;

public class NoSuchCountryException extends BasicTravelCheckedException {
    public NoSuchCountryException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_COUNTRY;
        this.message = "Desired country is not exists!";
    }
}
