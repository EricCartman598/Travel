package Travel_20190315.User.Domain;



import Travel_20190315.Order.Domain.Order;
import Travel_20190315.User.Domain.User;
import Travel_20190315.User.Domain.UserBonus;
import Travel_20190315.User.Domain.UserType;

import java.util.List;

public class VipUser extends User {

    private final boolean hasTransfer = true;
    private UserBonus bonus;


    public VipUser(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public VipUser(String firstName, String lastName, Passport passport, UserBonus bonus) {
        super(firstName, lastName, passport);
        this.bonus = bonus;
        allIncluded = true;
        userType = UserType.VIP_USER;
    }

    public VipUser(String firstName, String lastName, Passport passport, List<Order> orders, UserBonus bonus) {
        super(firstName, lastName, passport, orders);
        this.bonus = bonus;
        allIncluded = true;
        userType = UserType.VIP_USER;
    }

    public UserType getUserType() {
        return userType;
    }
}
