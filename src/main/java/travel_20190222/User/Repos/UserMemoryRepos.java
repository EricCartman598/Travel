/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190222.User.Repos;


import main.java.travel_20190222.User.User;

import static main.java.travel_20190222.Storage.Storage.users;
import main.java.travel_20190222.User.User.Passport;

/**
 *
 * @author Виталий
 */
public class UserMemoryRepos {

    public void addUser(User user) {
        users.add(user);        
    }
            
    public void setUserPassport(User user, String serial, String number) {
        Passport passport = user.new Passport(serial, number);
        user.setPassport(passport);
    }
    
    public User findUserById(Long id) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)) 
                return users.get(i);            
        }
                
        return null;        
    }
    
    public void deleteUserById(long id) {
        users.remove(id);
    }  
    
}
