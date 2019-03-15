package Travel_20190315.Common.Business.Exceptions;

import Travel_20190315.Common.Business.Exceptions.BasicTravelCheckedException;
import Travel_20190315.Common.Business.Exceptions.ErrorCode;
import Travel_20190315.Order.Domain.Order;

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