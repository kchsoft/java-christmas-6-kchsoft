package christmas.Validator;

import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

public class InputValidator {
    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_STRING.equals(value)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요");
        }
    }

}
