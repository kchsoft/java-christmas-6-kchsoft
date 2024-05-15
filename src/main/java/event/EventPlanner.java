package event;

import eventhistory.EventHistories;
import customer.Reservation;

import java.util.LinkedList;
import java.util.List;

public class EventPlanner {
    List<Event> events;

    public EventPlanner() {
        events = new LinkedList<>();
        events.add(new ChristmasDDayDiscountEvent());
    }

    public EventHistories apply(Reservation reservation) {
        EventHistories histories = new EventHistories();
        for (Event event : events) {
            histories.add(event.apply(reservation));
        }
        return histories;
    }

}
