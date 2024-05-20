package eventhistory;

import eventhistory.badge.BadgeEventHistory;
import eventhistory.gift.GiftEventHistory;
import restaurant.Badge;
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
            Object benefit = history.getBenefit();
            if (benefit instanceof UnmodifiedMoney) {
                money = ((UnmodifiedMoney) benefit);
                discount += money.getIntValue();
            }
        }
        return new Cost(discount);
    }

    public UnmodifiedMoney sumOfBenefitCost() {
        Integer benefitCost = 0;
        UnmodifiedMoney discount = sumOfDiscount();
        for (EventHistory history : eventHistories) {
            Object benefit = history.getBenefit();
            if (benefit instanceof Food) {
                Food food = ((Food) benefit);
                benefitCost += food.getIntCost();
            }
        }
        return new Cost(benefitCost + discount.getIntValue());
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

    public EventHistory getHistory(Integer index) {
        return eventHistories.get(index);
    }

    public Integer size() {
        return eventHistories.size();
    }

    public Badge getBadge() {
        for (EventHistory history : eventHistories) {
            if (history instanceof BadgeEventHistory) {
                return ((BadgeEventHistory) history).getBenefit();
            }

        }
        return null;
    }

}
