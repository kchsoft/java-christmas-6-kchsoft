package Event.Special;

import Event.EventHistory;
import christmas.Money;

public class SpecialDiscountEventHistory implements EventHistory<Money> {

    private final String eventName;
    private final Money discountAmount;

    public SpecialDiscountEventHistory(String eventName,Money discountAmount){
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
    public Money getBenefit() {
        return discountAmount;
    }

    public Integer getBenefitValue(){
        return discountAmount.getAmount();
    }

}
