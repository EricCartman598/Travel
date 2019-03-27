package travel_20190327.user.repo;


import travel_20190327.common.solution.repo.BaseRepo;
import travel_20190327.user.domain.User;
import travel_20190327.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
