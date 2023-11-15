package christmas.Converter;

import christmas.Validator.EventValidator;
import christmas.Validator.IntegerValidator;

public class Converter {

    public static Integer convertStringToDecemberDay(String value) throws IllegalArgumentException{
        Integer date = convertStringToInt(value);
        EventValidator.checkDecemberDay(date);
        return date;
    }

    public static Integer convertStringToInt(String value) throws IllegalArgumentException{
        IntegerValidator.checkEmptyValue(value);

        return Integer.valueOf(value);
    }

}