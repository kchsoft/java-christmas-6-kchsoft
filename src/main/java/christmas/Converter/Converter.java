package christmas.Converter;

import static christmas.Constant.MsgConstantPiece.COMMA;

import christmas.Validator.DayValidator;
import christmas.Validator.MenuValidator;
import java.util.Arrays;
import java.util.List;

public class Converter {

    public static Integer convertStringToDecemberDay(String value) throws IllegalArgumentException{
        DayValidator.checkDecemberDay(value);
        return Integer.valueOf(value);
    }


    public static List<String> convertCommaStringToList(String value) throws IllegalArgumentException {
        List<String> orderMenus = Arrays.asList(value.split(COMMA));
        MenuValidator.checkMenuInfo(orderMenus);
        return orderMenus;
    }

}