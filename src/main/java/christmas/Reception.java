package christmas;

import customer.Reservation;
import eventhistory.EventHistories;

public class Reception {

    private final Reservation reservation;
    private final EventHistories histories;


    public Reception(Reservation reservation) {
        this.reservation = reservation;
        this.histories = null;
    }

    public Reception(Reservation reservation, EventHistories histories) {
        this.reservation = reservation;
        this.histories = histories;
    }

}
