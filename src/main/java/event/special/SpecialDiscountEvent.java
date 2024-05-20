package event.special;

import customer.Reservation;
import customer.VisitingDay;
import event.PreCalculateEvent;
import eventhistory.EventHistory;
import eventhistory.special.SpecialDiscountEventHistory;
import money.Cost;
import money.UnmodifiedMoney;

import java.util.HashSet;

public class SpecialDiscountEvent implements PreCalculateEvent {
    HashSet<VisitingDay> discountSheet;
    private final UnmodifiedMoney DEFAULT_DISCOUNT_COST = new Cost(1000);

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
            return new SpecialDiscountEventHistory(new Cost(0));
        }
        return new SpecialDiscountEventHistory(DEFAULT_DISCOUNT_COST);
    }
}
