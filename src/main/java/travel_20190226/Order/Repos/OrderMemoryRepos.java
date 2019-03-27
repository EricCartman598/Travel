/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190226.Order.Repos;

import Travel_20190226.Order.Order;

import static Travel_20190226.Storage.Storage.orders;


/**
 *
 * @author Виталий
 */
public class OrderMemoryRepos {

    public void addOrder(Order order) {
        orders.add(order);        
    }
    
    public Order findOrderById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id))
                return order;
        }

        return null;        
    }
    
    public void deleteOrderById(long id) {
        orders.remove(id);
    }    
    
}
