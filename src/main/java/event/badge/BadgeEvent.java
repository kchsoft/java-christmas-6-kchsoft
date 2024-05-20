package event.badge;

import event.PostCalculateEvent;
import restaurant.Badge;
import eventhistory.badge.BadgeEventHistory;
import eventhistory.EventHistories;
import eventhistory.EventHistory;
import money.UnmodifiedMoney;

public class BadgeEvent implements PostCalculateEvent {

    public BadgeEvent() {
    }

    @Override
    public EventHistory apply(EventHistories histories) {
        UnmodifiedMoney discount = histories.sumOfBenefitCost();
        if (discount.getIntValue() >= Badge.STAR.getIntValue() && discount.getIntValue() < Badge.TREE.getIntValue()) {
            return new BadgeEventHistory(Badge.STAR);
        } else if (discount.getIntValue() >= Badge.TREE.getIntValue() && discount.getIntValue() < Badge.SANTA.getIntValue()) {
            return new BadgeEventHistory(Badge.TREE);
        } else if (discount.getIntValue() >= Badge.SANTA.getIntValue()) {
            return new BadgeEventHistory(Badge.TREE);
        }
        return new BadgeEventHistory(null);
    }

}