package travel_20190322.common.business.search;

public abstract class BaseSearchCondition {
    private Long id;
    private SortOrderDirection orderDirection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SortOrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(SortOrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }
}
