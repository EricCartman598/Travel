package travel_20190315.common.business.exceptions;

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
