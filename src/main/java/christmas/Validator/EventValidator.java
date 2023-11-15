package christmas.Validator;

import static Event.Constant.EventConstant.DAY_DISCOUNT_EVENT_FINAL_DATE;
import static Event.Constant.EventConstant.EVENT_START_DATE;
import static Event.Constant.EventConstant.MAX_MENU_NUMBER;
import static christmas.Constant.MsgConstantPiece.DASH;
import static christmas.Constant.RestaurantMenuConstant.BEVERAGE;

import christmas.Menu;
import christmas.Order;
import java.util.Arrays;
import java.util.List;

public class EventValidator {

    public static void checkDecemberDay(Integer day) throws IllegalArgumentException{
        if(day < EVENT_START_DATE || day > DAY_DISCOUNT_EVENT_FINAL_DATE){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요");
        }
    }

    public static void checkMenuName(String name) {
    }

    public static void checkMenuInfo(List<String> orderMenus) throws IllegalArgumentException{
        for (String oneMenu : orderMenus) {
            MenuValidator.checkMenuFormat(oneMenu);
            List<String> nameAndNumber = Arrays.asList(oneMenu.split(DASH));
            MenuValidator.checkMenuName(nameAndNumber.get(0));
            IntegerValidator.checkPositiveNumber(nameAndNumber.get(1));
        }
    }


}