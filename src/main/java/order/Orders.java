package order;

import food.Food;
import money.Cost;
import money.UnmodifiedMoney;

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

    public List<Food> getFoods() {
        List<Food> foods = new LinkedList<>();
        for (Integer index = 0; index < orders.size(); index++) {
            foods.add(orders.get(index).getFood());
        }
        return foods;
    }

    public UnmodifiedMoney getTotalCost() {
        Integer sum = 0;
        for (Order order : orders) {
            sum += order.getIntCost() * order.getAmount();
        }
        return new Cost(sum);
    }

    public Integer getTotalAmount() {
        Integer allAmount = 0;
        for (Order order : orders) {
            allAmount += order.getAmount();
        }
        return allAmount;
    }

    public Order findOrder(Food targetFood) {
        for (Integer index = 0; index < orders.size(); index++) {
            Order order = orders.get(index);
            if (order.getFood() == targetFood) {
                return order;
            }
        }
        return null;
    }

    public Integer getAmount(Food food) {
        Order order = findOrder(food);
        return order.getAmount();
    }

}
