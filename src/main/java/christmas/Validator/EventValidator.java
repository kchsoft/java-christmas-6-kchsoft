package christmas.Validator;

import static Event.Constant.EventConstant.DAY_DISCOUNT_EVENT_FINAL_DATE;
import static Event.Constant.EventConstant.EVENT_START_DATE;
import static Event.Constant.EventConstant.MAX_MENU_NUMBER;
import static christmas.Constant.RestaurantMenuConstant.BEVERAGE;

import christmas.Menu;
import christmas.Order;

public class EventValidator {

    public static void checkDecemberDay(Integer day) throws IllegalArgumentException{
        if(day < EVENT_START_DATE || day > DAY_DISCOUNT_EVENT_FINAL_DATE){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요");
        }
    }

    public static void checkMenuName(String name) {
    }

    public static void checkPositiveInteger(String value){
    }

    public static void checkMaxMenuNumber(Order order) throws IllegalArgumentException{
        Integer orderCount = 0;
        for (Menu menu : order.getMenus()) {
            orderCount += order.countNumberOf(menu);
        }
        if (orderCount > MAX_MENU_NUMBER) {
            throw new IllegalArgumentException("[ERROE] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    public static void checkOnlyBeverageOrder(Order order) throws IllegalArgumentException{
        for (Menu menu : order.getMenus()) {
            if(menu.getType() != BEVERAGE){
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

}