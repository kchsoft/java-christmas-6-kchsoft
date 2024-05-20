package eventhistory;

import food.Food;
import money.Cost;
import money.UnmodifiedMoney;

import java.util.LinkedList;
import java.util.List;

public class EventHistories {

    private final List<EventHistory> eventHistories;

    public EventHistories() {
        eventHistories = new LinkedList<>();
    }

    public void add(EventHistory history) {
        eventHistories.add(history);
    }

    public UnmodifiedMoney sumOfDiscount() {
        Integer discount = 0;
        UnmodifiedMoney money;
        for (EventHistory history : eventHistories) {
            money = history.getBenefitValue();
            discount += money.getIntValue();
        }
        return new Cost(discount);
    }

    public Food getGift() {
        Food gift = null;
        for (EventHistory history : eventHistories) {
            if (history instanceof GiftEventHistory) {
                gift = (Food)history.getBenefit();
            }
        }
        return gift;
    }
}
