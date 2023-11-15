package christmas;

import christmas.Validator.EventValidator;

public class Converter {

    public static Integer convertStringToDecemberDay(String value) {
        Integer date = convertStringToInt(value);
        EventValidator.checkDecemberDay(date);
        return date;
    }

    public static Integer convertStringToInt(String value){
        return 5;
    }

}