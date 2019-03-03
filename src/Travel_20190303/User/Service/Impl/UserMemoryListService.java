/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190303.User.Service.Impl;


import Travel_20190303.Order.Service.Impl.OrderMemoryListService;
import Travel_20190303.Order.Service.OrderService;
import Travel_20190303.User.Domain.User;
import Travel_20190303.User.Repos.Impl.UserMemoryListRepos;
import Travel_20190303.User.Repos.UserRepos;
import Travel_20190303.User.Search.UserSearchCondition;
import Travel_20190303.User.Service.UserService;

import java.util.List;

/**
 *
 * @author Виталий
 */
public class UserMemoryListService implements UserService {
    
    private UserRepos userRepos;

    public UserMemoryListService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @Override
    public void addUser(User user, User.Passport passport) {
        userRepos.setUserPassport(user, passport);
        userRepos.addUser(user);
    }

    public User findUserById(Long id) {
        if(id != null)
            return userRepos.findUserById(id);

        return null;
    }

    @Override
    public List<User> findUserByCondition(UserSearchCondition userSearchCondition) {
        return userRepos.findUserByCondition(userSearchCondition);
    }


    @Override
    public void deleteById(Long id) {
        userRepos.deleteById(id);
    }

    @Override
    public void printAll() {
        userRepos.printAll();
    }

    @Override
    public void update() {
        userRepos.update();
    }
}
