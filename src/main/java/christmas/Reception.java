package christmas;

import customer.Reservation;
import eventhistory.EventHistories;
import food.Food;
import money.UnmodifiedMoney;

import java.util.List;

public class Reception {

    private final Reservation reservation;
    private final EventHistories histories;


    public Reception(Reservation reservation) {
        this.reservation = reservation;
        this.histories = new EventHistories();
    }

    public Reception(Reservation reservation, EventHistories histories) {
        this.reservation = reservation;
        this.histories = histories;
    }

    public boolean hasEventHistories() {
        return histories.size() > 0;
    }

    public List<Food> getFoods() {
        return reservation.getFoods();
    }

    public Integer getAmount(Food food) {
        return reservation.getAmount(food);
    }

    public UnmodifiedMoney getTotalCost() {
        return reservation.getTotalCost();
    }

    public Food getGift() {
        if(histories == null) return null;
        return histories.getGift();
    }

    public EventHistories getEventHistories() {
        return histories;
    }

    public UnmodifiedMoney getDiscount() {
        return histories.sumOfDiscount();
    }

    public UnmodifiedMoney getBenefitCost() {
        return histories.sumOfBenefitCost();
    }

    public Badge getBadge() {
        return histories.getBadge();
    }
}
