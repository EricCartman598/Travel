package travel_20190326.common.business.search;

import travel_20190326.common.business.search.SortOrderDirection;

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
