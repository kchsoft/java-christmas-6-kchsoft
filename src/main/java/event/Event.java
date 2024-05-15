package event;

import customer.Reservation;
import eventhistory.EventHistory;

public interface Event {
    public EventHistory apply(Reservation reservation);

}
