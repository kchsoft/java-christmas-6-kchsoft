package event;

import customer.Reservation;
import eventhistory.ChristmasDDayDiccountEventHistory;
import eventhistory.EventHistory;
import customer.VisitingDay;

import java.util.HashMap;

public class ChristmasDDayDiscountEvent extends DiscountEvent{
    private final HashMap<VisitingDay, Integer> discountSheet;
    private final Integer DEFAULT_DISCOUNT_COST = 1000;
    private final Integer PLUS_DISCOUNT_COST = 100;

    public ChristmasDDayDiscountEvent() {
        discountSheet = new HashMap<>();
        for (Integer index = 1; index <= 25; index++) {
            discountSheet.put(new VisitingDay(index),
                    DEFAULT_DISCOUNT_COST + (index-1) * PLUS_DISCOUNT_COST);
        }
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        return new ChristmasDDayDiccountEventHistory(
                discountSheet.getOrDefault(reservation.getVisitingDay(), 0)
        );
    }

}
