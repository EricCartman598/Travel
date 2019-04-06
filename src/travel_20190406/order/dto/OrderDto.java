package travel_20190406.order.dto;

import travel_20190406.common.business.domain.BaseDomain;
import travel_20190406.common.business.dto.BaseDomainDto;
import travel_20190406.country.domain.BaseCountry;
import travel_20190406.country.dto.BaseCountryDto;
import travel_20190406.user.dto.UserDto;

import java.util.List;

public class OrderDto extends BaseDomainDto<Long> {
    private UserDto user;
    private double price;
    private List<BaseCountryDto> countries;


    public OrderDto(UserDto user, double price, List<BaseCountryDto> countries) {
        super();
        this.user = user;
        this.price = price;
        this.countries = countries;
    }



    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<BaseCountryDto> getCountries() {
        return countries;
    }

    public void setCountries(List<BaseCountryDto> countries) {
        this.countries = countries;
    }
}
