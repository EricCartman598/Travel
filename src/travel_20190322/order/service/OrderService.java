package main.java.travel_20190322.order.service;


import main.java.travel_20190322.common.solution.service.BaseService;
import main.java.travel_20190322.order.domain.Order;
import main.java.travel_20190322.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    //void deleteCityFromOrder(order targetOrder, Country targetCountry, city targetCity);
}
