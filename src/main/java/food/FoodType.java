package food;

public enum FoodType {
    APPETIZER("Appetizer"),
    MAIN("Main"),
    DESSERT("Dessert"),
    BEVERAGE("Beverage");

    private final String name;

    FoodType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
