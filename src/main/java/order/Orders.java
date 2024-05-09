package order;

import java.util.LinkedList;
import java.util.List;

public class Orders {
    private final List<Order> foodOrders;

    public Orders() {
        this.foodOrders = new LinkedList<>();
    }

    public void add(Order newOrder) throws IllegalArgumentException{
        checkDuplication(newOrder);
        foodOrders.add(newOrder);
    }

    private void checkDuplication(Order newOrder) throws IllegalArgumentException{
        for (Order order : foodOrders) {
            if (order.equals(newOrder) == true) {
                throw new IllegalArgumentException();
            }
        }
    }
}
