package order;

import converter.Converter;
import food.Food;

public class Order {
    private final Food food;
    private final Integer amount;

    public Order(OrderFormat orderFormat) throws IllegalArgumentException{
        this.food  = Food.findbyName(orderFormat.getName());
        this.amount = Converter.stringToInt(orderFormat.getAmount());
    }

    public Order(Food food, Integer amount) {
        this.food = food;
        this.amount = amount;
    }

    public Food getFood() {
        return food;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object foodOrder){
        if (foodOrder == null || !(foodOrder instanceof Order)) {
            return false;
        }
        if (this.food == ((Order) foodOrder).getFood()) {
            return true;
        }
        return false;
    }
}
