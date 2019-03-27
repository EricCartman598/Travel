package main.java.travel_20190303.User.Repos;

import main.java.travel_20190303.Common.Business.Repos.BaseRepos;
import main.java.travel_20190303.User.Domain.User;
import main.java.travel_20190303.User.Search.UserSearchCondition;

import java.util.List;

public interface UserRepos extends BaseRepos {
    void addUser(User user);

    //void setUserPassport(user user, user.Passport passport);

    User findUserById(long id);

    List<User> findUserByCondition(UserSearchCondition userSearchCondition);
}
