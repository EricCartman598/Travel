package main.java.travel_20190322.order.search;

import main.java.travel_20190322.common.business.search.BaseSearchCondition;
import main.java.travel_20190322.common.business.search.SortOrderDirection;
import main.java.travel_20190322.common.solution.search.Paginator;
import main.java.travel_20190322.country.domain.BaseCountry;
import main.java.travel_20190322.user.domain.UserType;

public class OrderSearchCondition extends BaseSearchCondition {

    private String countryName;
    private BaseCountry country;
    private UserType userType;
    Paginator paginator;
    //private SortOrderDirection sortOrderDirection;

    public OrderSearchCondition(String countryName, SortOrderDirection sortOrderDirection, Paginator paginator) {
        this.countryName = countryName;
        this.country = new BaseCountry(countryName);
        this.userType = UserType.ANY_TYPE;
        super.setOrderDirection(sortOrderDirection);
        this.paginator = paginator;
    }

    public OrderSearchCondition(BaseCountry country, Paginator paginator) {
        this.country = country;
        this.userType = UserType.ANY_TYPE;
        this.paginator = paginator;
    }

    public OrderSearchCondition(BaseCountry country, UserType userType, Paginator paginator) {
        this.country = country;
        this.userType = userType;
        this.paginator = paginator;
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

    public Paginator getPaginator() {
        return paginator;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;


    }
}
