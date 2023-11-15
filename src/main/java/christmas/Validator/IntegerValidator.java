package christmas.Validator;

import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

public class IntegerValidator {

    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_STRING.equals(value)){
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }
}
