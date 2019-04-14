package main.java.travel_20190319.order.repo;



import main.java.travel_20190319.common.solution.repo.BaseRepo;
import main.java.travel_20190319.order.domain.Order;
import main.java.travel_20190319.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    //void deleteCityFromOrder(order targetOrder, Country targetCountry, city targetCity);
}
