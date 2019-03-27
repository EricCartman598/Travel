package main.java.travel_20190322.common.business.domain;

public abstract class BaseDomain<T> {
    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public BaseDomain() {
    }
}
