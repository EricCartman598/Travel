package main.java.travel_20190303.Order.Repos;

import main.java.travel_20190303.Common.Business.Repos.BaseRepos;
import main.java.travel_20190303.Order.Domain.Order;
import main.java.travel_20190303.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderRepos extends BaseRepos {

    void addOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition);
}
