package Travel_20190315.Common.Business.Exceptions;

import Travel_20190315.Common.Business.Exceptions.ErrorCode;

public class BasicTravelCheckedException extends Exception {
    protected int errorCode;
    protected String message;

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
