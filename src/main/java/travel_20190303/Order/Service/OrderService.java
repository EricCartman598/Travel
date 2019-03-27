package main.java.travel_20190303.Order.Service;


import main.java.travel_20190303.Common.Business.Service.BaseService;
import main.java.travel_20190303.Order.Domain.Order;
import main.java.travel_20190303.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService {

    void addOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition);
}
