/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190303.User.Repos.Impl;


import Travel_20190303.User.Domain.User;
import Travel_20190303.User.Repos.UserRepos;
import Travel_20190303.User.Search.UserSearchCondition;

import java.util.List;

import static Travel_20190303.Storage.Storage.users;

/**
 *
 * @author Виталий
 */
public class UserMemoryListRepos implements UserRepos {

    private static long sequence = 0;

    @Override
    public void addUser(User user) {
        user.setId(generateSequence());
        users.add(user);        
    }

    @Override
    public void setUserPassport(User user, User.Passport passport) {
        user.setPassport(passport);
    }

    @Override
    public User findUserById(long id) {
        for (User user : users) {
            if (user.getId().equals(id))
                return user;
        }
                
        return null;        
    }

    @Override
    public List<User> findUserByCondition(UserSearchCondition userSearchCondition) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        users.remove(findUserById(id));
    }

    @Override
    public void printAll() {
        for(User user : users) {
            System.out.println("user firstname: " + user.getFirstName() + "\r\n" +
                    "userLastName: " + user.getLastName() + "\r\n" +
                    "passport serial: " + user.getPassport().getSerial());
        }
    }

    @Override
    public void update() {
        users = users;
    }

    @Override
    public long generateSequence() {
        return ++sequence;
    }
}
