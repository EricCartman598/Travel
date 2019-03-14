package Travel_20190313.Order.Service;


import Travel_20190313.City.Domain.City;
import Travel_20190313.Common.Solution.Service.BaseService;
import Travel_20190313.Country.Domain.Country;
import Travel_20190313.Order.Domain.Order;
import Travel_20190313.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    void deleteCityFromOrder(Order targetOrder, Country targetCountry, City targetCity);
}
