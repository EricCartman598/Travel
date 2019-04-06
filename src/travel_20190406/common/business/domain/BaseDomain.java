package travel_20190406.common.business.domain;

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
