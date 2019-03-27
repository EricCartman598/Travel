package Travel_20190313.Order.Repo;



import Travel_20190313.City.Domain.City;
import Travel_20190313.Common.Solution.Repo.BaseRepo;
import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Order.Domain.Order;
import Travel_20190313.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    void deleteCityFromOrder(Order targetOrder, Country targetCountry, City targetCity);
}
