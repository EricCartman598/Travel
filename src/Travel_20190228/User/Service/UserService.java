package Travel_20190228.User.Service;

import Travel_20190228.Common.Business.Service.BaseService;
import Travel_20190228.User.Domain.User;

public interface UserService extends BaseService {

    void addUser(User user, User.Passport passport);

    User findUserById(Long id);
}
