package travel_20190327.order.service;


import travel_20190327.common.solution.service.BaseService;
import travel_20190327.order.domain.Order;
import travel_20190327.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    //void deleteCityFromOrder(order targetOrder, Country targetCountry, city targetCity);
}
