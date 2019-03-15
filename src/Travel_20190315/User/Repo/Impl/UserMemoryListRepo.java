/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_20190315.User.Repo.Impl;


import Travel_20190315.Storage.SequenceGenerator;
import Travel_20190315.User.Domain.User;
import Travel_20190315.User.Repo.UserRepo;
import Travel_20190315.User.Search.UserSearchCondition;

import java.util.List;

import static Travel_20190315.Storage.Storage.users;

/**
 *
 * @author Виталий
 */
public class UserMemoryListRepo implements UserRepo {


    @Override
    public List<User> findByCondition(UserSearchCondition searchCondition) {
        return null;
    }

    @Override
    public void add(User data) {
        data.setId(SequenceGenerator.generateSequence());
        users.add(data);
    }

    @Override
    public User findById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id))
                return user;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        users.remove(findById(id));
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
    public void update(User data) {

    }
}


