package Event.DayDiscount;

import Event.EventHistory;
import christmas.Money;

public class DayDiscountEventHistory implements EventHistory<Money> {

    private final String eventName;
    private final Money discountAmount;

    public DayDiscountEventHistory(String eventName,Money discountAmount){
        this.eventName = eventName;
        this.discountAmount = discountAmount;
    }

    @Override
    public String explainName() {
        return eventName;
    }

    @Override
    public String explainBenefit() {
        return discountAmount.toString();
    }

    @Override
    public Money getBenefit(){
        return discountAmount;
    }

    public Integer getBenefitValue() {
        return discountAmount.getAmount();
    }
}
