/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel_20190327.user.service.impl;


import travel_20190327.common.solution.search.Paginator;
import travel_20190327.country.domain.BaseCountry;
import travel_20190327.user.domain.User;
import travel_20190327.user.repo.UserRepo;
import travel_20190327.user.search.UserSearchCondition;
import travel_20190327.user.service.UserService;

import java.util.Collection;
import java.util.List;

/**
 * @author Виталий
 */
public class UserMemoryListService implements UserService {

    private final UserRepo userRepo;

    public UserMemoryListService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findByCondition(UserSearchCondition searchCondition) {
        return userRepo.findByCondition(searchCondition);
    }

    @Override
    public void add(User data) {
        if (data != null)
            userRepo.add(data);
    }

    @Override
    public void add(Collection<User> data) {
        if (data != null) {
            for (User user : data) {
                add(user);
            }
        }
    }

    @Override
    public User findById(Long id) {
        if (id != null)
            return userRepo.findById(id);

        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void printAll(Paginator paginator) {
        userRepo.printAll(paginator);
    }

    @Override
    public void update(User data) {

    }
}


