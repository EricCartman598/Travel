package main.java.travel_20190315.common.business.exceptions;

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
