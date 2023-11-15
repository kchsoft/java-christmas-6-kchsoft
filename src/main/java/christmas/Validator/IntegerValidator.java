package christmas.Validator;

import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

public class IntegerValidator {

    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_STRING.equals(value)){
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }

    public static void checkPositiveNumber(String value) throws IllegalArgumentException {
        for (char oneValue : value.toCharArray()) {
            if(oneValue < '0' || oneValue > '9'){
                throw new IllegalArgumentException("[ERROR] 양의 정수만 입력이 가능합니다.");
            }
        }
    }
}
