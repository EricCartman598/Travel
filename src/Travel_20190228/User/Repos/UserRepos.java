package Travel_20190228.User.Repos;

import Travel_20190228.Common.Business.Repos.BaseRepos;
import Travel_20190228.User.Domain.User;

public interface UserRepos extends BaseRepos {
    void addUser(User user);

    void setUserPassport(User user, User.Passport passport);

    User findUserById(long id);


}
