package main.java.travel_20190307.Common.Solution.Service;

public interface BaseService<T, ID> {

    void add(T data);

    T findById(ID id);

    void deleteById(ID id);

    void printAll();

    void update(T data);
}
