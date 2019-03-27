package main.java.travel_20190313.Common.Business.Exceptions;

public class BasicTravelCheckedException extends Exception {
    protected ErrorCode errorCode;
    protected String message;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
