package travel_20190322.order.repo;



import travel_20190322.common.solution.repo.BaseRepo;
import travel_20190322.order.domain.Order;
import travel_20190322.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    long ordersByCountry(Long id);

    long ordersByCity(Long id);

    //void deleteCityFromOrder(order targetOrder, BaseCountry targetCountry, city targetCity);
}
