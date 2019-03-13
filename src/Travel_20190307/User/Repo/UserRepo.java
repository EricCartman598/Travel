package Travel_20190307.User.Repo;


import Travel_20190307.Common.Solution.Repo.BaseRepo;
import Travel_20190307.User.Domain.User;
import Travel_20190307.User.Search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
