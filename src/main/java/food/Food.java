package food;

import money.Cost;
import money.UnmodifiedMoney;

import static food.FoodType.*;

public enum Food {

    MUSHROOM_SOUP(APPETIZER, "양송이수프", new Cost(6000)),
    TAPAS(APPETIZER, "타파스", new Cost(5500)),
    CAESAR_SALAD(APPETIZER, "시저샐러드", new Cost(8000)),
    T_BONE_STEAK(MAIN, "티본스테이크", new Cost(55000)),
    BBQ_RIB(MAIN, "바비큐립", new Cost(54000)),
    SEAFOOD_PASTA(MAIN, "해산물파스타", new Cost(35000)),
    CHRISTMAS_PASTA(MAIN, "크리스마스파스타", new Cost(25000)),
    CHOCOLATE_CAKE(DESSERT, "초코케이크", new Cost(15000)),
    ICE_CREAM(DESSERT, "아이스크림", new Cost(5000)),
    ZERO_COLA(BEVERAGE, "제로콜라", new Cost(3000)),
    RED_WINE(BEVERAGE, "레드와인", new Cost(60000)),
    CHAMPAGNE(BEVERAGE, "샴페인", new Cost(25000));

    private final food.FoodType foodType;
    private final String name;
    private final UnmodifiedMoney cost;

    Food(food.FoodType foodType, String name, UnmodifiedMoney cost) {
        this.foodType = foodType;
        this.name = name;
        this.cost = cost;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public String getName() {
        return name;
    }

    public UnmodifiedMoney getCost() {
        return cost;
    }

    public Integer getIntCost() {
        return cost.getIntValue();
    }

    public static Food findByName(String name) throws IllegalArgumentException{
        for (Food food : Food.values()) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        throw new IllegalArgumentException();
    }
}
