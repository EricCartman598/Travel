package Travel_20190315.Order.Search;

import Travel_20190315.Common.Business.Search.BaseSearchCondition;
import Travel_20190315.Common.Business.Service.SortType;
import Travel_20190315.Country.Domain.BaseCountry;
import Travel_20190315.User.Domain.UserType;

public class OrderSearchCondition extends BaseSearchCondition {

    private String countryName;
    private BaseCountry country;
    private UserType userType;
    private SortType sortType;

    public OrderSearchCondition(String countryName, SortType sortType) {
        this.countryName = countryName;
        this.country = new BaseCountry(countryName);
        this.userType = UserType.ANY_TYPE;
        this.sortType = sortType;
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

    public SortType getSortType() {
        return sortType;
    }
}
