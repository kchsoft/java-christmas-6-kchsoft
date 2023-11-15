package View;


import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static christmas.Constant.InputMsgConstant.MSG_INPUT_VISITING_DAY;
import static christmas.Constant.InputMsgConstant.MSG_ORDER_MENU;

import camp.nextstep.edu.missionutils.Console;
import christmas.Converter.Converter;
import java.time.LocalDate;
import java.util.List;

public class InputView {

    public static LocalDate askVisitingDay() throws IllegalArgumentException{
        System.out.println(MSG_INPUT_VISITING_DAY);
        String value = Console.readLine();
        Integer date = Converter.convertStringToDecemberDay(value);
        return LocalDate.of(EVENT_YEAR, EVENT_MONTH, date);
    }

    public static List<String> askMenu() throws IllegalArgumentException{
        System.out.println(MSG_ORDER_MENU);
        String orderMenu = Console.readLine();
        return Converter.convertCommaStringToList(orderMenu);
    }

}
