package travel_20190406.order.repo.impl;

import travel_20190406.order.domain.Order;
import travel_20190406.order.repo.impl.OrderComparatorComponent;
import travel_20190406.order.search.OrderSearchCondition;

import java.util.Comparator;
import java.util.List;

public class OrderOrderingComponent {

    public void applyOrdering(List<Order> orders, OrderSearchCondition orderSearchCondition) {
        Comparator<Order> comparator = OrderComparatorComponent.getComparatorByNameField();

        if (comparator != null) {
            switch (orderSearchCondition.getOrderDirection()) {
                case ASC:
                    orders.sort(comparator);
                    break;
                case DESC:
                    orders.sort(comparator.reversed());
                    break;
            }
        }
    }
}
