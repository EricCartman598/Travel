/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190224.Order.Service;


import Travel_20190224.Country.Country;
import Travel_20190224.Country.Service.CountryMemoryService;
import Travel_20190224.Order.Order;
import Travel_20190224.Order.Repos.OrderMemoryRepos;

/**
 *
 * @author Виталий
 */
public class OrderMemoryService {

    private OrderMemoryRepos orderRepos = new OrderMemoryRepos();
    private CountryMemoryService countryService = new CountryMemoryService();
    
    public void addOrder(Order order) {
        orderRepos.addOrder(order);

        for(Country country : order.getCountries())
            countryService.addCountry(country);
    }

    public Order findOrderById(Long id) {
        return orderRepos.findOrderById(id);
    }

    public void deleteOrderById(long id) {
        orderRepos.deleteOrderById(id);
    }   
    
}
