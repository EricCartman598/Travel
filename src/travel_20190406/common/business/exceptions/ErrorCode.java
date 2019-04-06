package travel_20190406.common.business.exceptions;

public enum ErrorCode {

    NO_SUCH_COUNTRY(20),

    NO_SUCH_CITY(40),
    CANNOT_DELETE_CITY(41),

    ORDER_IS_ABOUT_TO_CANCELLED(60),
    NO_TICKETS(80),
    NO_SPARE_HOTEL_ROOMS(100),
    NO_ENOUGH_USER_MONEY(120);

    private int errorCode;

    ErrorCode(int val) {
        errorCode = val;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
