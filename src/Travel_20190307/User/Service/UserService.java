package Travel_20190307.User.Service;

import Travel_20190307.Common.Solution.Service.BaseService;
import Travel_20190307.User.Domain.User;
import Travel_20190307.User.Search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
