package main.java.travel_20190313.Order.Service;


import main.java.travel_20190313.City.Domain.City;
import main.java.travel_20190313.Common.Solution.Service.BaseService;
import main.java.travel_20190313.Country.Domain.Country;
import main.java.travel_20190313.Order.Domain.Order;
import main.java.travel_20190313.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    void deleteCityFromOrder(Order targetOrder, Country targetCountry, City targetCity);
}
