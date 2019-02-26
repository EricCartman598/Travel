/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190226.User.Service;


import Travel_20190226.User.User.Passport;
import Travel_20190226.Order.Repos.OrderMemoryRepos;
import Travel_20190226.User.Repos.UserMemoryRepos;
import Travel_20190226.User.User;

/**
 *
 * @author Виталий
 */
public class UserMemoryService {
    
    private UserMemoryRepos userRepos = new UserMemoryRepos();
    private OrderMemoryRepos orderRepos = new OrderMemoryRepos();
            
    public void addUser(User user, Passport passport) {
        userRepos.setUserPassport(user, passport);
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
