package Travel_20190307.Order.Repo;



import Travel_20190307.Common.Solution.Repo.BaseRepo;
import Travel_20190307.Order.Domain.Order;
import Travel_20190307.Order.Search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> findByCondition(OrderSearchCondition searchCondition);


}
