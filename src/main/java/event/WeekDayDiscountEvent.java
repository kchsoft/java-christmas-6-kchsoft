package event;

import customer.Reservation;
import eventhistory.EventHistory;
import eventhistory.WeekDayDiscountEventHistory;
import food.Food;
import food.FoodType;
import money.Cost;
import money.UnmodifiedMoney;

import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

public class WeekDayDiscountEvent extends DiscountEvent{

    private final UnmodifiedMoney DEFAULT_DISCOUNT_COST = new Cost(2023);
    private final List<DayOfWeek> days;
    private final FoodType eventFoodType;

    public WeekDayDiscountEvent() {
        days = new LinkedList<>();
        days.add(DayOfWeek.SUNDAY);
        days.add(DayOfWeek.MONDAY);
        days.add(DayOfWeek.THURSDAY);
        days.add(DayOfWeek.WEDNESDAY);
        days.add(DayOfWeek.THURSDAY);

        eventFoodType = FoodType.DESSERT;
    }

    @Override
    public EventHistory apply(Reservation reservation) {
        Integer discount = 0;
        if (!days.contains(reservation.getDay())) {
            return new WeekDayDiscountEventHistory(new Cost(discount));
        }

        for (Food food : reservation.getFoods()) {
            if (food.getFoodType() == eventFoodType) {
                discount += reservation.getAmount(food) * DEFAULT_DISCOUNT_COST.getIntValue();
            }
        }
        return new WeekDayDiscountEventHistory(new Cost(discount));
    }

}