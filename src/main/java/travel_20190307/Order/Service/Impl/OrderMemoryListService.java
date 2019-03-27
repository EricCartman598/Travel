/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190307.Order.Service.Impl;



import main.java.travel_20190307.Order.Domain.Order;
import main.java.travel_20190307.Order.Repo.OrderRepo;
import main.java.travel_20190307.Order.Search.OrderSearchCondition;
import main.java.travel_20190307.Order.Service.OrderService;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class OrderMemoryListService implements OrderService {

    private final OrderRepo orderRepo;

    public OrderMemoryListService(OrderRepo orderRepos) {
        this.orderRepo = orderRepos;
    }


    @Override
    public List<Order> findByCondition(OrderSearchCondition searchCondition) {
        return orderRepo.findByCondition(searchCondition);
    }

    @Override
    public void add(Order data) {
        if(data != null)
            orderRepo.add(data);
    }

    @Override
    public Order findById(Long id) {
        if(id != null)
            return orderRepo.findById(id);

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if(id != null)
            orderRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        orderRepo.printAll();
    }

    @Override
    public void update(Order data) {
        orderRepo.update(data);
    }
}

