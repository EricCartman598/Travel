package main.java.travel_20190228.Order.Repos;

import main.java.travel_20190228.Common.Business.Repos.BaseRepos;
import main.java.travel_20190228.Order.Domain.Order;
import main.java.travel_20190228.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderRepos extends BaseRepos {

    void addOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition);
}
