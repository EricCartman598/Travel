package main.java.travel_20190319.order.search;

import main.java.travel_20190319.common.business.search.BaseSearchCondition;
import main.java.travel_20190319.common.business.service.SortType;
import main.java.travel_20190319.country.domain.BaseCountry;
import main.java.travel_20190319.country.domain.CountryTemperatureType;
import main.java.travel_20190319.user.domain.UserType;

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
