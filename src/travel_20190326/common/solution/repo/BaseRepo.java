package travel_20190326.common.solution.repo;

import travel_20190326.common.solution.search.Paginator;

public interface BaseRepo<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id);

    void printAll(Paginator paginator);

    void update(T data);
}
