/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190222.User.Service;


import Travel_20190222.Order.Repos.OrderMemoryRepos;
import Travel_20190222.User.Repos.UserMemoryRepos;
import Travel_20190222.User.User;

/**
 *
 * @author Виталий
 */
public class UserMemoryService {
    
    private UserMemoryRepos userRepos = new UserMemoryRepos();
    private OrderMemoryRepos orderRepos = new OrderMemoryRepos();
            
    public void addUser(User user, String serial, String number) {
        userRepos.setUserPassport(user, serial, number);
        userRepos.addUser(user);
        
        for(int i = 0; i < user.getOrders().size(); i++) {
            orderRepos.addOrder(user.getOrders().get(i));
        }         
    }
        
    public User findUserById(Long id) {
        return userRepos.findUserById(id);
    }
        
    public void deleteUserById(long id) {
        userRepos.deleteUserById(id);
    }  
    
}
