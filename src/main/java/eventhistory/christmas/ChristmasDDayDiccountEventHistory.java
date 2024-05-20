package eventhistory.christmas;

import eventhistory.EventHistory;
import money.UnmodifiedMoney;

public class ChristmasDDayDiccountEventHistory implements EventHistory {
    private final UnmodifiedMoney discountCost;

    public ChristmasDDayDiccountEventHistory(UnmodifiedMoney discountCost) {
        this.discountCost = discountCost;
    }

    @Override
    public String getName() {
        return "크리스마스 디데이 할인";
    }

    @Override
    public UnmodifiedMoney getBenefit() {
        return discountCost;
    }

    @Override
    public UnmodifiedMoney getBenefitValue() {
        return discountCost;
    }

}
