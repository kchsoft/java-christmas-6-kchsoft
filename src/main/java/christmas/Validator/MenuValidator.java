package christmas.Validator;

import static Event.Constant.EventConstant.MAX_MENU_NUMBER;
import static christmas.Constant.ErrorMsgConstant.ERROR_EXCEED_MAX_ORDER_NUMBER;
import static christmas.Constant.ErrorMsgConstant.ERROR_NOT_VALID_ORDER;
import static christmas.Constant.ErrorMsgConstant.ERROR_ONLY_BEVERAGE_ORDER_NOT_ALLOW;
import static christmas.Constant.RestaurantMenuConstant.BEVERAGE;

import christmas.Menu;
import christmas.Order;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidator {

    public static void checkMaxMenuNumber(Order order) throws IllegalArgumentException{
        Integer orderCount = 0;
        for (Menu menu : order.getMenus()) {
            orderCount += order.countNumberOf(menu);
        }
        if (orderCount > MAX_MENU_NUMBER) {
            throw new IllegalArgumentException(ERROR_EXCEED_MAX_ORDER_NUMBER);
        }
    }

    public static void checkOnlyBeverageOrder(Order order) throws IllegalArgumentException{
        for (Menu menu : order.getMenus()) {
            if(menu.getType() != BEVERAGE){
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_ONLY_BEVERAGE_ORDER_NOT_ALLOW);
    }

    public static void checkMenuFormat(String value) throws IllegalArgumentException{
        String regex = "[가-힣a-zA-Z]+-[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_ORDER);
        }
    }

    public static void checkDuplication(List<String> checkValue) throws IllegalArgumentException{
        String deletedValue;
        while (checkValue.size() > 0) {
            deletedValue = checkValue.remove(0);
            if (checkValue.contains(deletedValue)) {
                throw new IllegalArgumentException(ERROR_NOT_VALID_ORDER);
            }
        }
    }

    public static void checkMenuName(String name) throws IllegalArgumentException{
        if (Menu.findMenu(name) == null) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_ORDER);
        }
    }

    public static void checkOrderCount(String value) throws IllegalArgumentException {
        checkZero(value);
        checkNumber(value);
        checkMaxInt(value);
    }

    private static void checkZero(String value) throws IllegalArgumentException{
        if (value.length() == 1 && value.charAt(0) == '0') {
            throw new IllegalArgumentException(ERROR_NOT_VALID_ORDER);
        }
    }

    private static void checkNumber(String value) throws IllegalArgumentException{
        for (char oneValue : value.toCharArray()) {
            if(oneValue < '0' || oneValue > '9'){
                throw new IllegalArgumentException(ERROR_NOT_VALID_ORDER);
            }
        }
    }

    private static void checkMaxInt(String value) throws IllegalArgumentException{
        Long bigValue = Long.valueOf(value);
        if (bigValue > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_ORDER);
        }

    }


}
