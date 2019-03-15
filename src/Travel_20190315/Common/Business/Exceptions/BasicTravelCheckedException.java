package Travel_20190315.Common.Business.Exceptions;

import Travel_20190315.Common.Business.Exceptions.ErrorCode;

public class BasicTravelCheckedException extends Exception {
    protected ErrorCode errorCode;
    protected String message;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
