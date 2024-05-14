package christmas;

import customer.Reservation;
import exception.EventApplyException;
import exception.FoodOrderException;

public class Watier {

    public Watier() {
    }

    public Reception confirm(Reservation reservation)  throws FoodOrderException{
        try {
            EventWarning.check(reservation);
        } catch (EventApplyException e) {
            Payment payment = new Payment(reservation, e);
            return new Reception(payment);
        } catch (FoodOrderException e){
            throw e;
        }
        Payment payment = new Payment(reservation);
        return new Reception(payment);
    }
}
