/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190222.Order.Repos;

import Travel_20190222.Order.Order;

import static Travel_20190222.Storage.Storage.orders;


/**
 *
 * @author Виталий
 */
public class OrderMemoryRepos {

    public void addOrder(Order order) {
        orders.add(order);        
    }
    
    public Order findOrderById(Long id) {
        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getId().equals(id)) 
                return orders.get(i);            
        }
                
        return null;        
    }
    
    public void deleteOrderById(long id) {
        orders.remove(id);
    }    
    
}
