package Travel_20190228.User.Service;

import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.User.Domain.User;
import Travel_20190228.User.Search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void addUser(User user, User.Passport passport);

    User findUserById(Long id);

    List<User> findUserByCondition(UserSearchCondition userSearchCondition);
}
