package main.java.travel_20190228.User.Service;

import main.java.travel_20190228.Common.Business.Service.BaseService;
import main.java.travel_20190228.User.Domain.User;
import main.java.travel_20190228.User.Search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void addUser(User user, User.Passport passport);

    User findUserById(Long id);

    List<User> findUserByCondition(UserSearchCondition userSearchCondition);
}
