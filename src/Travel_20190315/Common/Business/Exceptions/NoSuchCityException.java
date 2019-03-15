package Travel_20190315.Common.Business.Exceptions;

import Travel_20190315.Common.Business.Exceptions.BasicTravelCheckedException;
import Travel_20190315.Common.Business.Exceptions.ErrorCode;

public class NoSuchCityException extends BasicTravelCheckedException {
    public NoSuchCityException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_CITY;
        this.message = "Desired city is not exists!";
    }
}
