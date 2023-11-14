package Event.DateDiscount;

import static Event.Constant.EventNameConstant.CHRISTMAS_D_DAY_DISCOUNT_EVENT;
import static Event.Constant.EventConstant.DATE_DISCOUNT_EVENT_FINAL_DATE;

import Event.Event;
import Event.EventHistory;

import christmas.Money;
import christmas.Order;
import java.util.HashMap;

public class DateDiscountEvent implements Event<Order> {
    HashMap<Integer,Integer> dateSheet;
    private final Integer BASE_DISCOUNT = 1000;
    private final Integer DAILY_DISCOUNT_INCREASE = 100;

    public DateDiscountEvent(){
        this.dateSheet = new HashMap<>();
        for (int date = 1; date <= DATE_DISCOUNT_EVENT_FINAL_DATE; date++) {
            dateSheet.put(date, (date-1) * DAILY_DISCOUNT_INCREASE + BASE_DISCOUNT);
        }
    }

    @Override
    public EventHistory apply(Order order) {
        Integer date = order.getDate();
        if(dateSheet.containsKey(date)){
            Integer discountAmount = dateSheet.get(date);
            return new DateDiscountEventHistory(CHRISTMAS_D_DAY_DISCOUNT_EVENT,new Money(discountAmount));
        }
        return null;
    }
}
