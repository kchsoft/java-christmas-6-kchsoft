package converter;

import order.OrderFormat;
import order.OrderFormats;
import validator.InputValidator;

import java.util.LinkedList;
import java.util.List;

public class Converter {

    public static Integer stringToInt(String value) throws NumberFormatException {
        InputValidator.checkStringToInt(value);
        return Integer.valueOf(value);
    }

    public static OrderFormats stringToOrderFormats(String orderInfos) throws IllegalArgumentException {
        List<String> eachOrderInfo = splitOrderInfos(orderInfos);
        OrderFormats orderFormats = infoToOrderFormats(eachOrderInfo);
        return orderFormats;
    }

    private static List<String> splitOrderInfos(String infos) throws IllegalArgumentException{
        List<String> eachInfo = new LinkedList<>();
        for (String foodInfo : infos.split(",")) {
            eachInfo.add(foodInfo);
        }
        if(eachInfo.size() == 0) throw new IllegalArgumentException();
        return eachInfo;
    }


    private static OrderFormats infoToOrderFormats(List<String> eachOrderInfo) throws IllegalArgumentException{
        OrderFormat info;
        OrderFormats infos = new OrderFormats();
        for (String orderInfo : eachOrderInfo) {
            info = new OrderFormat(orderInfo);
            infos.add(info);
        }
        return infos;
    }

}