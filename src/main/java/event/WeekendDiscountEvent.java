package event;

import customer.Reservation;
import eventhistory.EventHistory;
import eventhistory.WeekendDiscountEventHistory;
import food.Food;
import food.FoodType;
import money.Cost;
import money.UnmodifiedMoney;

import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

public class WeekendDiscountEvent extends DiscountEvent{

    private final UnmodifiedMoney DEFAULT_DISCOUNT_COST = new Cost(2023);
    private final List<DayOfWeek> days;
    private final FoodType eventFoodType;

    public WeekendDiscountEvent() {
        this.days = new LinkedList<>();
        days.add(DayOfWeek.FRIDAY);
        days.add(DayOfWeek.SATURDAY);
        this.eventFoodType = FoodType.MAIN;
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        Integer discount = 0;
        if (!days.contains(reservation.getDay())) {
            return new WeekendDiscountEventHistory(new Cost(discount));
        }

        for (Food food : reservation.getFoods()) {
            if (food.getFoodType() == eventFoodType) {
                discount += reservation.getAmount(food) * DEFAULT_DISCOUNT_COST.getIntValue();
            }
        }
        return new WeekendDiscountEventHistory(new Cost(discount));
    }

}