package travel_20190406.user.repo;


import travel_20190406.common.solution.repo.BaseRepo;
import travel_20190406.user.domain.User;
import travel_20190406.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
