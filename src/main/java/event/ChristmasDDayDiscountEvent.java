package event;

import customer.Reservation;
import customer.VisitingDay;
import eventhistory.ChristmasDDayDiccountEventHistory;
import eventhistory.EventHistory;
import money.Cost;
import money.UnmodifiedMoney;

import java.util.HashMap;

public class ChristmasDDayDiscountEvent extends DiscountEvent{
    private final HashMap<VisitingDay, UnmodifiedMoney> discountSheet;
    private final UnmodifiedMoney DEFAULT_DISCOUNT_COST = new Cost(1000);
    private final UnmodifiedMoney PLUS_DISCOUNT_COST = new Cost(100);

    public ChristmasDDayDiscountEvent() {
        discountSheet = new HashMap<>();
        for (Integer index = 1; index <= 25; index++) {
            discountSheet.put(new VisitingDay(index),
                    new Cost(DEFAULT_DISCOUNT_COST.getIntValue()
                            + (index-1) * PLUS_DISCOUNT_COST.getIntValue()));
        }
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        return new ChristmasDDayDiccountEventHistory(
                discountSheet.getOrDefault(reservation.getVisitingDay(), new Cost(0))
        );
    }

}
