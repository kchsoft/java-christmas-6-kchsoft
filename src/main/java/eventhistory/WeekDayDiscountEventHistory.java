package eventhistory;

import money.UnmodifiedMoney;

public class WeekDayDiscountEventHistory implements EventHistory {

    private final UnmodifiedMoney discount;

    public WeekDayDiscountEventHistory(UnmodifiedMoney discountCost) {
        this.discount = discountCost;
    }

    @Override
    public String getName() {
        return "평일 할인";
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