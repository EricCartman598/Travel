package main.java.travel_20190307.Country.Repo;

import main.java.travel_20190307.Common.Solution.Repo.BaseRepo;
import main.java.travel_20190307.Country.Domain.Country;
import main.java.travel_20190307.Country.Search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<Country, Long> {

    Country findByName(String name);

    List<Country> findByCondition(CountrySearchCondition searchCondition);
}
