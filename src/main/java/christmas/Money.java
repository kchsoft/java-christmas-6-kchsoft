package christmas;

import static christmas.Constant.MsgConstantPiece.COMMA;
import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

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

    public void subtract(Money money){
        subtract(money.getAmount());
    }

    public void subtract(Integer money) {
        this.money -= money;
    }

    public String toString(){
        String value = String.valueOf(money);
        String commaValue = EMPTY_STRING;

        for (Integer Index =  1; Index <= value.length(); Index++) {
            commaValue = value.charAt(value.length() - Index) + commaValue;
            if (Index % 3 == 0 && Index < value.length()) {
                commaValue = COMMA + commaValue;
            }
        }
        return commaValue;
    }

}
