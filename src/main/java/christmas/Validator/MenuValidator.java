package christmas.Validator;

import static Event.Constant.EventConstant.DAY_DISCOUNT_EVENT_FINAL_DATE;
import static Event.Constant.EventConstant.EVENT_START_DATE;
import static Event.Constant.EventConstant.MAX_MENU_NUMBER;
import static christmas.Constant.RestaurantMenuConstant.BEVERAGE;

import christmas.Menu;
import christmas.Order;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidator {

    public static void checkMenuName(String name) {
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

    public static void checkMenuFormat(String value) throws IllegalArgumentException{
        String regex = "^(\\w+-[0-9]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
