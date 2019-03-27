package Travel_20190228.Common.Business.Domain;

public abstract class BaseDomain {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseDomain() {
    }
}
