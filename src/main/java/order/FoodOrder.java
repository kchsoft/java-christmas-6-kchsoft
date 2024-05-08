package order;

import menu.Food;

public class FoodOrder {
    private final Food food;
    private final Integer amount;

    public FoodOrder(Food food, Integer amount) {
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
        if (foodOrder == null || !(foodOrder instanceof FoodOrder)) {
            return false;
        }
        if (this.food == ((FoodOrder) foodOrder).getFood()) {
            return true;
        }
        return false;
    }
}
