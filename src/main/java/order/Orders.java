package order;

import java.util.LinkedList;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders() {
        this.orders = new LinkedList<>();
    }

    public void add(Order newOrder) throws IllegalArgumentException{
        checkDuplication(newOrder);
        orders.add(newOrder);
    }

    private void checkDuplication(Order newOrder) throws IllegalArgumentException{
        for (Order order : orders) {
            if (order.equals(newOrder) == true) {
                throw new IllegalArgumentException();
            }
        }
    }
}
