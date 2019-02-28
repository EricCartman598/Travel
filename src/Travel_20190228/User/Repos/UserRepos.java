package Travel_20190228.User.Repos;

import Travel_20190228.Common.Business.Repos.BaseRepos;
import Travel_20190228.User.Domain.User;
import Travel_20190228.User.Search.UserSearchCondition;

import java.util.List;

public interface UserRepos extends BaseRepos {
    void addUser(User user);

    void setUserPassport(User user, User.Passport passport);

    User findUserById(long id);

    List<User> findUserByCondition(UserSearchCondition userSearchCondition);
}
