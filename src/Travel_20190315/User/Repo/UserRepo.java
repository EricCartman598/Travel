package Travel_20190315.User.Repo;


import Travel_20190315.Common.Solution.Repo.BaseRepo;
import Travel_20190315.User.Domain.User;
import Travel_20190315.User.Search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
