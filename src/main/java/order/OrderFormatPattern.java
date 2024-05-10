package order;

import java.util.regex.Pattern;

public class OrderFormatPattern {
    private static final String regex = "[가-힣]+-[1-9]([0-9]*)(,[가-힣]+-[1-9][0-9]*)*";
    private static final Pattern pattern = Pattern.compile(regex);

    public static Boolean matches(String value) throws IllegalArgumentException{
        if (pattern.matcher(value).matches() == false) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
