package travel_20190406.user.dto;

import main.java.travel_20190228.User.Domain.UserType;
import travel_20190406.common.business.domain.BaseDomain;
import travel_20190406.common.business.dto.BaseDomainDto;
import travel_20190406.order.dto.OrderDto;

import java.util.List;

public class UserDto extends BaseDomainDto<Long> {
    protected String firstName;
    protected String lastName;
    protected Passport passport;
    protected List<OrderDto> orders;
    boolean allIncluded;
    UserType userType;
    String PhoneNumber;

    public class Passport {
        private String serial;
        private String number;

        public Passport(String serial, String number) {
            this.serial = serial;
            this.number = number;
        }

        public String getSerial() {
            return serial;
        }

        public String getNumber() {
            return number;
        }
    }

    public UserDto(String firstName, String lastName, Passport passport) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public UserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDto(String firstName, String lastName, Passport passport, List<OrderDto> orders) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Passport getPassport() {
        return passport;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPassport(String passportSerial, String passportNumber) {
        this.passport.serial = passportSerial;
        this.passport.number = passportNumber;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public boolean isAllIncluded() {
        return allIncluded;
    }

    public UserType getUserType() {
        return userType;
    }
}
