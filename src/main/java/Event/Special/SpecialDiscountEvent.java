package Event.Special;

import static Event.Constant.EventConstant.CHRISTMAS_DATE;
import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_START_DATE;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.SPECIAL_DISCOUNT;

import Event.Event;
import Event.EventHistory;
import christmas.Money;
import christmas.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountEvent implements Event<Order> {
    List<Integer> specialSheet;
    private final Integer SPECIAL_DISCOUNT_AMOUNT = 1000;

    public SpecialDiscountEvent(){
        specialSheet = new ArrayList<>();
        LocalDate date = LocalDate.of(EVENT_YEAR, EVENT_MONTH, EVENT_START_DATE);
        for (Integer specialDate = 1; specialDate <= date.lengthOfMonth(); specialDate++) {
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                specialSheet.add(specialDate);
            }
            date = date.plusDays(1);
        }
        specialSheet.add(CHRISTMAS_DATE);
    }

    @Override
    public EventHistory apply(Order order) {
        if (specialSheet.contains(order.getDate())) {
            return new SpecialDiscountEventHistory(SPECIAL_DISCOUNT,new Money(SPECIAL_DISCOUNT_AMOUNT));
        }
        return null;
    }

}
