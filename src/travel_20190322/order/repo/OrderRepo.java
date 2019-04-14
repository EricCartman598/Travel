package main.java.travel_20190322.order.repo;



import main.java.travel_20190322.common.solution.repo.BaseRepo;
import main.java.travel_20190322.order.domain.Order;
import main.java.travel_20190322.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    long ordersByCountry(Long id);

    long ordersByCity(Long id);

    //void deleteCityFromOrder(order targetOrder, Country targetCountry, city targetCity);
}
