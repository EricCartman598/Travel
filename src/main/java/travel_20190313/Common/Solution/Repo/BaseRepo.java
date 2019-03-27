package Travel_20190313.Common.Solution.Repo;

public interface BaseRepo<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id);

    void printAll();

    void update(T data);
}
