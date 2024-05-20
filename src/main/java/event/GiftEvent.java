package event;

import customer.Reservation;
import eventhistory.EventHistory;
import eventhistory.GiftEventHistory;
import food.Food;
import money.Cost;
import money.UnmodifiedMoney;

public class GiftEvent implements PreCalculateEvent {

    private final UnmodifiedMoney EVENT_APPLICATION_BASE_COST = new Cost(120000);

    public GiftEvent() {
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        UnmodifiedMoney cost = reservation.getTotalCost();
        if (cost.getIntValue() < EVENT_APPLICATION_BASE_COST.getIntValue()) {
            return new GiftEventHistory();
        }
        return new GiftEventHistory(Food.CHAMPAGNE);
    }

}