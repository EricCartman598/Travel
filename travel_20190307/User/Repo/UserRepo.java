package main.java.travel_20190307.User.Repo;


import main.java.travel_20190307.Common.Solution.Repo.BaseRepo;
import main.java.travel_20190307.User.Domain.User;
import main.java.travel_20190307.User.Search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
