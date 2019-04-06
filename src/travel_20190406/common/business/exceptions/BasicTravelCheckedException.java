package travel_20190406.common.business.exceptions;

import travel_20190406.common.business.exceptions.ErrorCode;

public class BasicTravelCheckedException extends Exception {
    protected ErrorCode errorCode;
    protected String message;

    public int getErrorCode() {
        return errorCode.getErrorCode();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
