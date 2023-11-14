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

}
