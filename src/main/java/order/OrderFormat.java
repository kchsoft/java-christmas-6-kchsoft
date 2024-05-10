package order;

public class OrderFormat {
    private final String name;
    private final String amount;

    public OrderFormat(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }
}