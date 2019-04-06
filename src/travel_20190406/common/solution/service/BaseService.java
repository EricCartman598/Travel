package travel_20190406.common.solution.service;

import travel_20190406.common.business.exceptions.CannotDeleteCityException;
import travel_20190406.common.business.exceptions.NeedToCancelOrderException;
import travel_20190406.common.solution.search.Paginator;

import java.util.Collection;

public interface BaseService<T, ID> {

    void add(T data);

    void add(Collection<T> data);

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException, CannotDeleteCityException;

    void printAll(Paginator paginator);

    void update(T data);
}
