package christmas.Converter;

import static christmas.Constant.MsgConstantPiece.COMMA;
import static christmas.Constant.MsgConstantPiece.DASH;

import christmas.Validator.EventValidator;
import christmas.Validator.IntegerValidator;
import christmas.Validator.MenuValidator;
import java.util.Arrays;
import java.util.List;

public class Converter {

    public static Integer convertStringToDecemberDay(String value) throws IllegalArgumentException{
        EventValidator.checkDecemberDay(value);
        return Integer.valueOf(value);
    }

    public static Integer convertStringToPositiveInt(String value) throws IllegalArgumentException{
        IntegerValidator.checkEmptyValue(value);
        IntegerValidator.checkPositiveNumber(value);
        return Integer.valueOf(value);
    }

    public static List<String> convertCommaStringToList(String value) throws IllegalArgumentException {
        List<String> orderMenus = Arrays.asList(value.split(COMMA));
        EventValidator.checkMenuInfo(orderMenus);
        return orderMenus;
    }

}