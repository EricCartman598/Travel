package main.java.travel_20190322.user.repo;


import main.java.travel_20190322.common.solution.repo.BaseRepo;
import main.java.travel_20190322.user.domain.User;
import main.java.travel_20190322.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
