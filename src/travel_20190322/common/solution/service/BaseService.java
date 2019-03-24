package travel_20190322.common.solution.service;

import travel_20190322.common.business.exceptions.CannotDeleteCityException;
import travel_20190322.common.business.exceptions.NeedToCancelOrderException;
import travel_20190322.common.solution.search.Paginator;

public interface BaseService<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException, CannotDeleteCityException;

    void printAll(Paginator paginator);

    void update(T data);
}
