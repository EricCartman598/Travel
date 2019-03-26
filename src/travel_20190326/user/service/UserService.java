package travel_20190326.user.service;

import travel_20190326.common.solution.service.BaseService;
import travel_20190326.user.domain.User;
import travel_20190326.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findByCondition(UserSearchCondition searchCondition);
}
