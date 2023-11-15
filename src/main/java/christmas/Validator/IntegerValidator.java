package christmas.Validator;

import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

public class IntegerValidator {



    public static void checkPositiveNumber(String value) throws IllegalArgumentException {
        for (char oneValue : value.toCharArray()) {
            if(oneValue < '0' || oneValue > '9'){
                throw new IllegalArgumentException("[ERROR] 양의 정수만 입력이 가능합니다.");
            }
        }
    }
}
