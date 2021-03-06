package travel_20190406.common.business.exceptions;

import travel_20190406.common.business.exceptions.BasicTravelCheckedException;
import travel_20190406.common.business.exceptions.ErrorCode;
import travel_20190406.order.domain.Order;

import java.util.List;

public class NeedToCancelOrderException extends BasicTravelCheckedException {

    private List<Order> cancelledOrders;
    public NeedToCancelOrderException(List<Order> cancelledOrders) {
        super();
        this.errorCode = ErrorCode.ORDER_IS_ABOUT_TO_CANCELLED;
        this.message = "Desired destination is not exists!";
        this.cancelledOrders = cancelledOrders;
    }

    public List<Order> getCancelledOrders() {
        return cancelledOrders;
    }
}
