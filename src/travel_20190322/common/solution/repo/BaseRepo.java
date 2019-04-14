package main.java.travel_20190322.common.solution.repo;

import main.java.travel_20190322.common.solution.search.Paginator;

public interface BaseRepo<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id);

    void printAll(Paginator paginator);

    void update(T data);
}
