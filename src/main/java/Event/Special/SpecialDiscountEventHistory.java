package Event.Special;

import Event.EventHistory;
import christmas.Money;

public class SpecialDiscountEventHistory implements EventHistory {

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

    public Integer getDiscountAmount() {
        return discountAmount.getAmount();
    }

}
