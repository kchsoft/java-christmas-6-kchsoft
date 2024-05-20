package restaurant;

import customer.Reservation;
import event.EventPlanner;
import eventhistory.EventHistories;
import exception.EventApplyException;

public class Payment {
    public static Reception calculate(Reservation reservation, EventApplyException exception){
        return new Reception(reservation);
    }

    public static Reception calculate(Reservation reservation){
        EventPlanner planner = new EventPlanner();
        EventHistories histories = planner.apply(reservation);
        return new Reception(reservation,histories);
    }

}