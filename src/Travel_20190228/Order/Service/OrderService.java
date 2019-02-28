package Travel_20190228.Order.Service;


import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.Order.Domain.Order;

public interface OrderService extends BaseService {

    void addOrder(Order order);

    Order findOrderById(Long id);
}
