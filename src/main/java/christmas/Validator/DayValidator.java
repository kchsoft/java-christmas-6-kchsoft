package christmas.Validator;

import static Event.Constant.EventConstant.DAY_DISCOUNT_EVENT_FINAL_DATE;
import static Event.Constant.EventConstant.EVENT_START_DATE;
import static christmas.Constant.ErrorMsgConstant.ERROR_NOT_VALID_DAY;
import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

public class DayValidator {

    public static void checkDecemberDay(String value) throws IllegalArgumentException{
        checkEmptyValue(value);
        checkPositiveInt(value);
        checkDayRange(value);
    }

    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_STRING.equals(value)){
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

    public static void checkDayRange(String value) {
        Integer day = Integer.valueOf(value);
        if(day < EVENT_START_DATE || day > DAY_DISCOUNT_EVENT_FINAL_DATE){
            throw new IllegalArgumentException(ERROR_NOT_VALID_DAY);
        }
    }

}