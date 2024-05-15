package event;

import customer.Reservation;
import eventhistory.EventHistory;
import eventhistory.GiftEventHistory;
import food.Food;

public class GiftEvent implements Event{

    private final Integer EVENT_APPLICATION_BASE_COST = 120000;

    public GiftEvent() {
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        if (reservation.getTotalCost() < EVENT_APPLICATION_BASE_COST) {
            return new GiftEventHistory();
        }
        return new GiftEventHistory(Food.RED_WINE);
    }

}