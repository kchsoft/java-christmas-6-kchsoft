package christmas.Converter;

import christmas.Validator.EventValidator;
import christmas.Validator.IntegerValidator;

public class Converter {

    public static Integer convertStringToDecemberDay(String value) throws IllegalArgumentException{
        Integer date = convertStringToPositiveInt(value);
        EventValidator.checkDecemberDay(date);
        return date;
    }

    public static Integer convertStringToPositiveInt(String value) throws IllegalArgumentException{
        IntegerValidator.checkEmptyValue(value);
        IntegerValidator.checkPositiveNumber(value);
        return Integer.valueOf(value);
    }

}