package main.java.travel_20190315.common.solution.service;

import main.java.travel_20190315.common.business.exceptions.NeedToCancelOrderException;

public interface BaseService<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException;

    void printAll();

    void update(T data);
}
