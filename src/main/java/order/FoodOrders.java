package order;



import java.util.LinkedList;
import java.util.List;

public class FoodOrders {
    private List<FoodOrder> foodOrders;

    public FoodOrders() {
        this.foodOrders = new LinkedList<>();
    }

    public void add(FoodOrder newOrder) throws IllegalArgumentException{
        for (FoodOrder order : foodOrders) {
            if (order.equals(newOrder) == true) {
                throw new IllegalArgumentException();
            }
        }
        foodOrders.add(newOrder);
    }
}
