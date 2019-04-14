package main.java.travel_20190322.common.business.exceptions;

import main.java.travel_20190322.common.business.exceptions.ErrorCode;

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
