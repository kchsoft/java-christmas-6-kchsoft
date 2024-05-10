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

    public static OrderFormats stringToOrderFormats(String customerOrderInfo) {
        OrderInfos orderInfo = stringToOrderInfos(customerOrderInfo);
        return orderInfosToOrderFormats(orderInfo);
    }

    public static OrderInfos stringToOrderInfos(String customerOrderInfo) {
        OrderInfos orderInfos = new OrderInfos();
        for (String orderInfo : customerOrderInfo.split(",")) {
            orderInfos.add(orderInfo);
        }
        return orderInfos;
    }

    public static OrderFormats orderInfosToOrderFormats(OrderInfos orderInfos) {
        OrderFormats formats = new OrderFormats();
        for (int index = 0 ; index < orderInfos.size() ; index++) {
            String orderInfo = orderInfos.get(index);
            String[] nameAmount = orderInfo.split("-");
            formats.add(new OrderFormat(nameAmount[0],nameAmount[1]));
        }
        return formats;
    }

}