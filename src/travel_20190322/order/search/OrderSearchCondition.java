package travel_20190322.order.search;

import travel_20190322.common.business.search.BaseSearchCondition;
import travel_20190322.common.business.search.SortOrderDirection;
import travel_20190322.country.domain.BaseCountry;
import travel_20190322.user.domain.UserType;

public class OrderSearchCondition extends BaseSearchCondition {

    private String countryName;
    private BaseCountry country;
    private UserType userType;
    //private SortOrderDirection sortOrderDirection;

    public OrderSearchCondition(String countryName, SortOrderDirection sortOrderDirection) {
        this.countryName = countryName;
        this.country = new BaseCountry(countryName);
        this.userType = UserType.ANY_TYPE;
        super.setOrderDirection(sortOrderDirection);
    }

    public OrderSearchCondition(BaseCountry country) {
        this.country = country;
        this.userType = UserType.ANY_TYPE;
    }

    public OrderSearchCondition(BaseCountry country, UserType userType) {
        this.country = country;
        this.userType = userType;
    }

    public BaseCountry getCountry() {
        return country;
    }

    public void setCountry(BaseCountry country) {
        this.country = country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public SortOrderDirection getSortOrderDirection() {
        return super.getOrderDirection();
    }
}
