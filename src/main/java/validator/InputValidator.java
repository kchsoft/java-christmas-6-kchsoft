package validator;

public class InputValidator {

    public static void checkStringToInt(String value) throws NumberFormatException{
        try {
            Integer intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
