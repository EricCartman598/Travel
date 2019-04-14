package main.java.travel_20190307.User.Service;

import main.java.travel_20190307.Common.Solution.Service.BaseService;
import main.java.travel_20190307.User.Domain.User;
import main.java.travel_20190307.User.Search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
