package main.java.travel_20190303.User.Service;

import main.java.travel_20190303.User.Search.UserSearchCondition;
import main.java.travel_20190303.Common.Business.Service.BaseService;
import main.java.travel_20190303.User.Domain.User;


import java.util.List;

public interface UserService extends BaseService {

    void addUser(User user);

    User findUserById(Long id);

    List<User> findUserByCondition(UserSearchCondition userSearchCondition);
}
