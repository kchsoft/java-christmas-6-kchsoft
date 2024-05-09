package order;

public class FoodOrderFormat {
    private final String name;
    private final String amount;

    public FoodOrderFormat(String value) throws IllegalArgumentException{
        String[] values = splitByDash(value);
        this.name = values[0];
        this.amount = values[1];
    }

    public FoodOrderFormat(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    private String[] splitByDash(String value) throws  IllegalArgumentException{
        String[] nameAmount = value.split("-");
        if(nameAmount.length != 2)
            throw new IllegalArgumentException();
        return nameAmount;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }
}