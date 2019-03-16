package travel_20190315.order.repo;



import travel_20190315.common.solution.repo.BaseRepo;
import travel_20190315.order.domain.Order;
import travel_20190315.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    //void deleteCityFromOrder(order targetOrder, BaseCountry targetCountry, city targetCity);
}
