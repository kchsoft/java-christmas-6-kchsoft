package View;


import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static christmas.Constant.MsgConstantPiece.COMMA;
import static christmas.Constant.MsgConstantPiece.DASH;
import static christmas.Constant.MsgConstantPiece.LINE_BREAKER;

import camp.nextstep.edu.missionutils.Console;
import christmas.Converter.Converter;
import christmas.Validator.EventValidator;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static LocalDate askVisitingDay() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다." + LINE_BREAKER
                + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String value = Console.readLine();
        Integer date = Converter.convertStringToInt(value);
        return LocalDate.of(EVENT_YEAR, EVENT_MONTH, date);
    }

    public static List<String> askMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String orderMenu = Console.readLine();
        List<String> orderMenus = Arrays.asList(orderMenu.split(COMMA));

        for (String oneMenu : orderMenus) {
            List<String> nameAndNumber = Arrays.asList(oneMenu.split(DASH));
            EventValidator.checkMenuName(nameAndNumber.get(0));
            EventValidator.checkPositiveInteger(nameAndNumber.get(1));
        }
        return orderMenus;
    }

}
