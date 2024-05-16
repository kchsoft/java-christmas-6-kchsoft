package event;

import christmas.Badge;
import eventhistory.BadgeEventHistory;
import eventhistory.EventHistories;
import eventhistory.EventHistory;

public class BadgeEvent implements PostCalculateEvent {

    public BadgeEvent() {
    }

    @Override
    public EventHistory apply(EventHistories histories) {
        Integer discount = histories.sumOfDiscount();
        if (discount >= Badge.STAR.getBaseCost() && discount < Badge.TREE.getBaseCost()) {
            return new BadgeEventHistory(Badge.STAR);
        } else if (discount >= Badge.TREE.getBaseCost() && discount < Badge.SANTA.getBaseCost()) {
            return new BadgeEventHistory(Badge.TREE);
        } else if (discount >= Badge.SANTA.getBaseCost()) {
            return new BadgeEventHistory(Badge.TREE);
        }
        return new BadgeEventHistory(null);
    }

}