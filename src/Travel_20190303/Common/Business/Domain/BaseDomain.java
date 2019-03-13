package Travel_20190303.Common.Business.Domain;

public abstract class BaseDomain <ID> {
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public BaseDomain() {
    }
}
