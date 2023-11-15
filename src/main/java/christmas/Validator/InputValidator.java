package christmas.Validator;

import static christmas.Constant.ErrorMsgConstant.ERROR_NOT_VALID_DAY;
import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

public class InputValidator {
    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_STRING.equals(value)){
            throw new IllegalArgumentException(ERROR_NOT_VALID_DAY);
        }
    }

}
