package Event;

import static Event.EventNameConstant.WEEKDAY_DISCOUNT;
import static Event.EventNameConstant.WEEKEND_DISCOUNT;
import static christmas.RestaurantMenuConstant.DESSERT;
import static christmas.RestaurantMenuConstant.MAIN;

import christmas.Menu;
import christmas.Money;
import christmas.Order;
import java.time.DayOfWeek;
import java.util.List;

public class DayDiscountEvent implements Event<Order> {

    private final Integer MENU_DISCOUNT = 2023;

    public DayDiscountEvent(){
    }

    @Override
    public EventHistory apply(Order order) {
        if(order.getDay() == DayOfWeek.FRIDAY || order.getDay() == DayOfWeek.SATURDAY ){
            return applyWeekendMainDiscount(order);
        } else if (order.getDay() != DayOfWeek.FRIDAY && order.getDay() != DayOfWeek.SATURDAY) {
            return applyWeekdayDessertDiscount(order);
        }
        return null;
    }

    private EventHistory applyWeekdayDessertDiscount(Order order){
        Integer dessertCount = 0;
        List<Menu> dessertMenu = order.getMenusOfType(DESSERT);
        for (Menu menu : dessertMenu) {
            dessertCount += order.countNumberOf(menu);
        }
        return new DayDiscountEventHistory(WEEKDAY_DISCOUNT, new Money(MENU_DISCOUNT * dessertCount));
    }

    private EventHistory applyWeekendMainDiscount(Order order){
        Integer mainCount = 0;
        List<Menu> dessertMenu = order.getMenusOfType(MAIN);
        for (Menu menu : dessertMenu) {
            mainCount += order.countNumberOf(menu);
        }
        return new DayDiscountEventHistory(WEEKEND_DISCOUNT, new Money(MENU_DISCOUNT * mainCount));
    }

}
