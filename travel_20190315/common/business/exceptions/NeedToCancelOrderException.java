package main.java.travel_20190315.common.business.exceptions;

import main.java.travel_20190315.order.domain.Order;

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
