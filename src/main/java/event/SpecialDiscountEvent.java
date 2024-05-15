package event;

import customer.Reservation;
import customer.VisitingDay;
import eventhistory.EventHistory;
import eventhistory.SpecialDiscountEventHistory;

import java.util.HashSet;

public class SpecialDiscountEvent implements Event{
    HashSet<VisitingDay> discountSheet;
    private final Integer DEFAULT_DISCOUNT_COST = 1000;

    public SpecialDiscountEvent() {
        this.discountSheet = new HashSet<>();
        for (Integer day = 3; day <= 31; day += 7) {
            discountSheet.add(new VisitingDay(day));
        }
        discountSheet.add(new VisitingDay(25));
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        if (!discountSheet.contains(reservation.getVisitingDay())) {
            return new SpecialDiscountEventHistory(0);
        }
        return new SpecialDiscountEventHistory(DEFAULT_DISCOUNT_COST);
    }
}
