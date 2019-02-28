package Travel_20190228.Country.Repos;

import Travel_20190228.Common.Business.Repos.BaseRepos;
import Travel_20190228.Country.Domain.Country;

public interface CountryRepos extends BaseRepos {

    void addCountry(Country country);

    Country findCountryById(long id);
}
