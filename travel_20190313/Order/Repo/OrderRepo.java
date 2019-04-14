package main.java.travel_20190313.Order.Repo;



import main.java.travel_20190313.City.Domain.City;
import main.java.travel_20190313.Common.Solution.Repo.BaseRepo;
import main.java.travel_20190313.Country.Domain.Country;
import main.java.travel_20190313.Order.Domain.Order;
import main.java.travel_20190313.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    void deleteCityFromOrder(Order targetOrder, Country targetCountry, City targetCity);
}
