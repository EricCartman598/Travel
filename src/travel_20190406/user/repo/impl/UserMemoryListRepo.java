/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190406.user.repo.impl;


import travel_20190406.common.solution.search.Paginator;
import travel_20190406.storage.SequenceGenerator;
import travel_20190406.user.domain.User;
import travel_20190406.user.repo.UserRepo;
import travel_20190406.user.search.UserSearchCondition;

import java.util.List;

import static travel_20190406.storage.Storage.users;

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
    public void printAll(Paginator paginator) {
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


