package travel_20190327.order.repo;



import travel_20190327.common.solution.repo.BaseRepo;
import travel_20190327.order.domain.Order;
import travel_20190327.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    long ordersByCountry(Long id);

    long ordersByCity(Long id);

    //void deleteCityFromOrder(order targetOrder, Country targetCountry, city targetCity);
}
