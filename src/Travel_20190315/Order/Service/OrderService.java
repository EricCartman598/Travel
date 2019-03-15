package Travel_20190315.Order.Service;


import Travel_20190315.City.Domain.City;
import Travel_20190315.Common.Solution.Service.BaseService;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.Order.Domain.Order;
import Travel_20190315.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);

    //void deleteCityFromOrder(Order targetOrder, BaseCountry targetCountry, City targetCity);
}
