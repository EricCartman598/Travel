package Travel_20190303.Order.Search;

import Travel_20190303.Common.Business.Search.BaseSearchCondition;
import Travel_20190303.Country.Domain.Country;
import Travel_20190303.User.Domain.UserType;

public class OrderSearchCondition extends BaseSearchCondition {

    private Country country;
    private UserType userType;

    public OrderSearchCondition(Country country) {
        this.country = country;
        this.userType = UserType.ANY_TYPE;
    }

    public OrderSearchCondition(Country country, UserType userType) {
        this.country = country;
        this.userType = userType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
