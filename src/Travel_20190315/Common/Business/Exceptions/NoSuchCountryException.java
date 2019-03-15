package Travel_20190315.Common.Business.Exceptions;

import Travel_20190315.Common.Business.Exceptions.BasicTravelCheckedException;
import Travel_20190315.Common.Business.Exceptions.ErrorCode;

public class NoSuchCountryException extends BasicTravelCheckedException {
    public NoSuchCountryException() {
        super();
        this.errorCode = ErrorCode.NO_SUCH_COUNTRY;
        this.message = "Desired country is not exists!";
    }
}
