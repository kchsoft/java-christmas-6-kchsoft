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
        if (discount >= Badge.STAR.getIntValue() && discount < Badge.TREE.getIntValue()) {
            return new BadgeEventHistory(Badge.STAR);
        } else if (discount >= Badge.TREE.getIntValue() && discount < Badge.SANTA.getIntValue()) {
            return new BadgeEventHistory(Badge.TREE);
        } else if (discount >= Badge.SANTA.getIntValue()) {
            return new BadgeEventHistory(Badge.TREE);
        }
        return new BadgeEventHistory(null);
    }

}