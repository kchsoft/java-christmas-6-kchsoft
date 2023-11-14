package christmas;

public class Money {
    private Integer money;

    public Money(){
        this.money = 0;
    }

    public Money(Integer money) {
        this.money = money;
    }

    public Integer getAmount(){
        return money;
    }

    public void add(Money money) {
        add(money.getAmount());
    }

    public void add(Integer money) {
        this.money += money;
    }

    public String toString(){
        String commaValue = "";

        commaValue = money % 1000 + commaValue;
        money /= 1000;

        while (money != 0) {
            commaValue = "," + commaValue;
            commaValue = money % 1000 + commaValue;
            money /= 1000;
        }
        return commaValue;
    }
}
