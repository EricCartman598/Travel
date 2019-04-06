package travel_20190406.common.solution.repo;

import travel_20190406.common.solution.search.Paginator;

import java.util.Collection;

public interface BaseRepo<T, ID> {

    void add(T data);

    //void add(Collection<T> data);

    T findById(ID id);

    void deleteById(ID id);

    void printAll(Paginator paginator);

    void update(T data);
}
