/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.travel_20190319.user.repo.impl;


import main.java.travel_20190319.storage.SequenceGenerator;
import main.java.travel_20190319.user.domain.User;
import main.java.travel_20190319.user.repo.UserRepo;
import main.java.travel_20190319.user.search.UserSearchCondition;

import java.util.List;

import static main.java.travel_20190319.storage.Storage.users;

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


