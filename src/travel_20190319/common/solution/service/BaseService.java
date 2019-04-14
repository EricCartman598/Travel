package main.java.travel_20190319.common.solution.service;

import main.java.travel_20190319.common.business.exceptions.NeedToCancelOrderException;

public interface BaseService<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id) throws NeedToCancelOrderException;

    void printAll();

    void update(T data);
}
