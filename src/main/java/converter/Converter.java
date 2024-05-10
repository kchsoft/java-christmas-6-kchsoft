package converter;

import order.OrderFormat;
import order.OrderFormats;
import order.OrderInfos;
import validator.InputValidator;

public class Converter {

    public static Integer stringToInt(String value) throws NumberFormatException {
        InputValidator.checkStringToInt(value);
        return Integer.valueOf(value);
    }

    public static OrderFormats stringToOrderFormats(String customerOrderInfo) throws IllegalArgumentException {
        OrderInfos orderInfo = stringToOrderInfos(customerOrderInfo);
        return orderInfosToOrderFormats(orderInfo);
    }

    public static OrderInfos stringToOrderInfos(String customerOrderInfo) throws IllegalArgumentException{
        OrderInfos orderInfos = new OrderInfos();
        for (String orderInfo : customerOrderInfo.split(",")) {
            orderInfos.add(orderInfo);
        }
        if(orderInfos.size() == 0) throw new IllegalArgumentException();
        return orderInfos;
    }

    public static OrderFormats orderInfosToOrderFormats(OrderInfos orderInfos) throws IllegalArgumentException{
        OrderFormat format;
        OrderFormats formats = new OrderFormats();
        for (int index = 0 ; index < orderInfos.size() ; index++) {
            format = new OrderFormat(orderInfos.get(index));
            formats.add(format);
        }
        return formats;
    }

}