package travel_20190322.common.solution.service;

import travel_20190322.common.business.exceptions.CannotDeleteCityException;
import travel_20190322.common.business.exceptions.NeedToCancelOrderException;

public interface BaseService<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException, CannotDeleteCityException;

    void printAll();

    void update(T data);
}
