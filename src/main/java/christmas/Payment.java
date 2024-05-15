package christmas;

import customer.Reservation;
import exception.EventApplyException;

public class Payment {
    public static Reception calculate(Reservation reservation, EventApplyException exception){
        return new Reception(reservation);
    }

    public static Reception calculate(Reservation reservation){
        return new Reception(reservation);
    }

}
