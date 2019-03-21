package travel_20190319.common.solution.repo;

public interface BaseRepo<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id);

    void printAll();

    void update(T data);
}
