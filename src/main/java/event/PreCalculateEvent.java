package event;

import customer.Reservation;
import eventhistory.EventHistory;

public interface PreCalculateEvent {
    public EventHistory apply(Reservation reservation);

}
