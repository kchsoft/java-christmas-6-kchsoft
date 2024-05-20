package eventhistory;

import money.UnmodifiedMoney;

public class SpecialDiscountEventHistory implements EventHistory {
    private final UnmodifiedMoney discount;

    public SpecialDiscountEventHistory(UnmodifiedMoney discount) {
        this.discount = discount;
    }

    @Override
    public String getName() {
        return "특별 할인";
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
