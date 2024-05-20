package eventhistory.weekend;

import eventhistory.EventHistory;
import money.UnmodifiedMoney;

public class WeekendDiscountEventHistory implements EventHistory {

    private final UnmodifiedMoney discount;

    public WeekendDiscountEventHistory(UnmodifiedMoney discount) {
        this.discount = discount;
    }

    @Override
    public String getName() {
        return "주말 할인";
    }

    @Override
    public UnmodifiedMoney getBenefit() {
        return discount;
    }

    @Override
    public UnmodifiedMoney getBenefitValue() {
        return discount;
    }
}