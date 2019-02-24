/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190224.User.Repos;


import Travel_20190224.User.User.Passport;
import Travel_20190224.User.User;

import static Travel_20190224.Storage.Storage.users;

/**
 *
 * @author Виталий
 */
public class UserMemoryRepos {

    public void addUser(User user) {
        users.add(user);        
    }
            
    public void setUserPassport(User user, Passport passport) {
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
