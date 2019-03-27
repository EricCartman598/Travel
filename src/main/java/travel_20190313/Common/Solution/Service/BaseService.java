package main.java.travel_20190313.Common.Solution.Service;

import main.java.travel_20190313.Common.Business.Exceptions.NeedToCancelOrderException;
import main.java.travel_20190313.Common.Business.Exceptions.NoSuchCityException;
import main.java.travel_20190313.Common.Business.Exceptions.NoSuchCountryException;

public interface BaseService<T, ID> {

    void add(T data) throws NoSuchCountryException, NoSuchCityException;

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException;

    void printAll();

    void update(T data);
}
