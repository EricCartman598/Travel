package main.java.travel_20190307.Order.Service;


import main.java.travel_20190307.Common.Solution.Service.BaseService;
import main.java.travel_20190307.Order.Domain.Order;
import main.java.travel_20190307.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);
}
