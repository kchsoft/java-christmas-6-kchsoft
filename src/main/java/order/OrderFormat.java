package order;

public class OrderFormat {
    private final String name;
    private final String amount;

    public OrderFormat(String orderInfo) throws IllegalArgumentException{
        String[] orderInfos = splitByDash(orderInfo);
        this.name = orderInfos[0];
        this.amount = orderInfos[1];
    }

    public OrderFormat(String name, String amount) {
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