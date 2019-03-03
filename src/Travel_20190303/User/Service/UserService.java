package Travel_20190303.User.Service;

import Travel_20190303.User.Search.UserSearchCondition;
import Travel_20190303.Common.Business.Service.BaseService;
import Travel_20190303.User.Domain.User;


import java.util.List;

public interface UserService extends BaseService {

    void addUser(User user, User.Passport passport);

    User findUserById(Long id);

    List<User> findUserByCondition(UserSearchCondition userSearchCondition);
}
