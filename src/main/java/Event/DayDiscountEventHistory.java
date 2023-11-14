package Event;

import christmas.Money;

public class DayDiscountEventHistory implements EventHistory{

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

    public Integer getDiscountAmount(){
        return discountAmount.getAmount();
    }
}
