package travel_20190327.user.service;

import travel_20190327.common.solution.service.BaseService;
import travel_20190327.user.domain.User;
import travel_20190327.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
