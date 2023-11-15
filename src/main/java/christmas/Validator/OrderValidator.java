package christmas.Validator;

import static Event.Constant.EventConstant.MAX_MENU_NUMBER;
import static christmas.Constant.ErrorMsgConstant.ERROR_EXCEED_MAX_ORDER_NUMBER;
import static christmas.Constant.ErrorMsgConstant.ERROR_ONLY_BEVERAGE_ORDER_NOT_ALLOW;
import static christmas.Constant.RestaurantMenuConstant.BEVERAGE;

import christmas.Menu;
import christmas.Order;

public class OrderValidator {

    public static void checkOrderInfo(Order order) throws IllegalArgumentException{
        checkMaxMenuNumber(order);
        checkOnlyBeverageOrder(order);
    }

    private static void checkMaxMenuNumber(Order order) throws IllegalArgumentException{
        Integer orderCount = 0;
        for (Menu menu : order.getMenus()) {
            orderCount += order.countNumberOf(menu);
        }
        if (orderCount > MAX_MENU_NUMBER) {
            throw new IllegalArgumentException(ERROR_EXCEED_MAX_ORDER_NUMBER);
        }
    }

    private static void checkOnlyBeverageOrder(Order order) throws IllegalArgumentException{
        for (Menu menu : order.getMenus()) {
            if(menu.getType() != BEVERAGE){
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_ONLY_BEVERAGE_ORDER_NOT_ALLOW);
    }

}
