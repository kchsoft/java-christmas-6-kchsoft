package converter;

import validator.InputValidator;

public class Converter {

    public static Integer StringToInt(String value) throws NumberFormatException {
        InputValidator.checkStringToInt(value);
        return Integer.valueOf(value);
    }

}