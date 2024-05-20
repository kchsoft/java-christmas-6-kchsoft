package event;

import customer.Reservation;
import event.badge.BadgeEvent;
import event.christmas.ChristmasDDayDiscountEvent;
import event.gift.GiftEvent;
import event.special.SpecialDiscountEvent;
import event.weekday.WeekDayDiscountEvent;
import event.weekend.WeekendDiscountEvent;
import eventhistory.EventHistories;

import java.util.LinkedList;
import java.util.List;

public class EventPlanner {
    List<PreCalculateEvent> preEvents;
    List<PostCalculateEvent> postEvents;

    public EventPlanner() {
        preEvents = new LinkedList<>();
        preEvents.add(new ChristmasDDayDiscountEvent());
        preEvents.add(new WeekDayDiscountEvent());
        preEvents.add(new WeekendDiscountEvent());
        preEvents.add(new SpecialDiscountEvent());
        preEvents.add(new GiftEvent());

        postEvents = new LinkedList<>();
        postEvents.add(new BadgeEvent());
    }

    public EventHistories apply(Reservation reservation) {
        EventHistories histories = preCalculate(reservation);
        postCalculate(histories);
        return histories;
    }

    private EventHistories preCalculate(Reservation reservation) {
        EventHistories histories = new EventHistories();
        for (PreCalculateEvent event : preEvents) {
            histories.add(event.apply(reservation));
        }
        return histories;
    }

    private void postCalculate(EventHistories histories) {
        for (PostCalculateEvent event : postEvents) {
            histories.add(event.apply(histories));
        }
    }

}