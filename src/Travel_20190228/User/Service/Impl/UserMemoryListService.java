/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190228.User.Service.Impl;


import Travel_20190228.Order.Service.Impl.OrderMemoryListService;
import Travel_20190228.Order.Service.OrderService;
import Travel_20190228.User.Domain.User;
import Travel_20190228.User.Repos.Impl.UserMemoryListRepos;
import Travel_20190228.User.Repos.UserRepos;
import Travel_20190228.User.Service.UserService;

/**
 *
 * @author Виталий
 */
public class UserMemoryListService implements UserService {
    
    private UserRepos userRepos = new UserMemoryListRepos();
    private OrderService orderService = new OrderMemoryListService();

    @Override
    public void addUser(User user, User.Passport passport) {
        userRepos.setUserPassport(user, passport);
        userRepos.addUser(user);
        
        for(int i = 0; i < user.getOrders().size(); i++) {
            orderService.addOrder(user.getOrders().get(i));
        }         
    }

    public User findUserById(Long id) {
        if(id != null)
            return userRepos.findUserById(id);

        return null;
    }


    @Override
    public void deleteById(Long id) {
        userRepos.deleteById(id);
    }

    @Override
    public void printAll() {
        userRepos.printAll();
    }
}
