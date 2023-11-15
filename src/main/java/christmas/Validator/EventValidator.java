package christmas.Validator;

import static Event.Constant.EventConstant.DAY_DISCOUNT_EVENT_FINAL_DATE;
import static Event.Constant.EventConstant.EVENT_START_DATE;
import static Event.Constant.EventConstant.MAX_MENU_NUMBER;
import static christmas.Constant.ErrorMsgConstant.ERROR_NOT_VALID_DAY;
import static christmas.Constant.MsgConstantPiece.DASH;
import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;
import static christmas.Constant.RestaurantMenuConstant.BEVERAGE;

import christmas.Menu;
import christmas.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventValidator {

    public static void checkDecemberDay(String value) throws IllegalArgumentException{
        checkPositiveInt(value);
        Integer day = Integer.valueOf(value);
        if(day < EVENT_START_DATE || day > DAY_DISCOUNT_EVENT_FINAL_DATE){
            throw new IllegalArgumentException(ERROR_NOT_VALID_DAY);
        }
    }

    private static void checkPositiveInt(String value) throws IllegalArgumentException {
        for (char oneValue : value.toCharArray()) {
            if(oneValue < '0' || oneValue > '9'){
                throw new IllegalArgumentException(ERROR_NOT_VALID_DAY);
            }
        }
    }



    public static void checkMenuInfo(List<String> orderMenus) throws IllegalArgumentException{
        List<String> checkValue = new ArrayList<>();
        for (String oneMenu : orderMenus) {
            MenuValidator.checkMenuFormat(oneMenu);
            List<String> nameAndNumber = Arrays.asList(oneMenu.split(DASH));
            MenuValidator.checkMenuName(nameAndNumber.get(0));
            MenuValidator.checkOrderCount(nameAndNumber.get(1));
            checkValue.add(nameAndNumber.get(0));
        }
        MenuValidator.checkDuplication(checkValue);
    }


}