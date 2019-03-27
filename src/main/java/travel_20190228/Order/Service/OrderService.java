package Travel_20190228.Order.Service;


import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.Order.Domain.Order;
import Travel_20190228.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService {

    void addOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition);
}
