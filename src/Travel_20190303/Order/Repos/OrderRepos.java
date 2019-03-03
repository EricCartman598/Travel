package Travel_20190303.Order.Repos;

import Travel_20190303.Common.Business.Repos.BaseRepos;
import Travel_20190303.Order.Domain.Order;
import Travel_20190303.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderRepos extends BaseRepos {

    void addOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition);
}
