package eventhistory;

import money.UnmodifiedMoney;
import food.Food;

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

    public Integer sumOfDiscount() {
        Integer discount = 0;
        UnmodifiedMoney money;
        for (EventHistory history : eventHistories) {
            money = history.getBenefitValue();
            discount += money.getIntValue();
        }
        return discount;
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
