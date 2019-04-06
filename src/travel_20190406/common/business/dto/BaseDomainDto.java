package travel_20190406.common.business.dto;

public abstract class BaseDomainDto<T> {
    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public BaseDomainDto() {
    }
}
