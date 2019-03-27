/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190303.Order.Service.Impl;



import Travel_20190303.Country.Domain.Country;
import Travel_20190303.Country.Service.CountryService;
import Travel_20190303.Country.Service.Impl.CountryMemoryListService;
import Travel_20190303.Order.Domain.Order;
import Travel_20190303.Order.Repos.Impl.OrderMemoryListRepos;
import Travel_20190303.Order.Repos.OrderRepos;
import Travel_20190303.Order.Search.OrderSearchCondition;
import Travel_20190303.Order.Service.OrderService;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class OrderMemoryListService implements OrderService {

    private final OrderRepos orderRepos;

    public OrderMemoryListService(OrderRepos orderRepos) {
        this.orderRepos = orderRepos;
    }

    @Override
    public void addOrder(Order order) {
        orderRepos.addOrder(order);
    }

    @Override
    public Order findOrderById(Long id) {
        if(id != null)
            return orderRepos.findOrderById(id);

        return null;
    }

    @Override
    public List<Order> findOrderByCondition(OrderSearchCondition orderSearchCondition) {
        return orderRepos.findOrderByCondition(orderSearchCondition);
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            orderRepos.deleteById(id);
    }

    @Override
    public void printAll() {
        orderRepos.printAll();
    }

    @Override
    public void update() {
        orderRepos.update();
    }


}
