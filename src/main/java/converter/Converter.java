package converter;

import order.FoodOrderFormat;
import order.FoodOrderFormats;
import validator.InputValidator;

import java.util.LinkedList;
import java.util.List;

public class Converter {

    public static Integer stringToInt(String value) throws NumberFormatException {
        InputValidator.checkStringToInt(value);
        return Integer.valueOf(value);
    }

    public static FoodOrderFormats stringToFoodOrderFormats(String foodInfos) throws IllegalArgumentException {
        try {
            List<String> eachFoodInfo = splitFoodInfos(foodInfos);
            FoodOrderFormats orderFormats = infoToFoodOrderFormats(eachFoodInfo);
            return orderFormats;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static List<String> splitFoodInfos(String infos) throws IllegalArgumentException{
        List<String> eachInfo = new LinkedList<>();
        for (String foodInfo : infos.split(",")) {
            eachInfo.add(foodInfo);
        }
        if(eachInfo.size() == 0) throw new IllegalArgumentException();
        return eachInfo;
    }


    private static FoodOrderFormats infoToFoodOrderFormats(List<String> eachFoodInfo) throws IllegalArgumentException{
        FoodOrderFormat info;
        FoodOrderFormats infos = new FoodOrderFormats();
        for (String foodInfo : eachFoodInfo) {
            info = new FoodOrderFormat(foodInfo);
            infos.add(info);
        }
        return infos;
    }

}