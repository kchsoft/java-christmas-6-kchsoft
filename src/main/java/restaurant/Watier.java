package restaurant;

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
            return Payment.calculate(reservation,e);
        } catch (FoodOrderException e){
            System.out.println(e.getMessage());
            return null;
        }
        return Payment.calculate(reservation);
    }

}