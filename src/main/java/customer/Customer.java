package customer;

import camp.nextstep.edu.missionutils.Console;
import converter.Converter;
import order.Order;
import order.OrderFormatPattern;
import order.OrderFormats;
import order.Orders;

public class Customer {
    public VisitingDay reserve() throws IllegalArgumentException{
        try {
            String value = Console.readLine();
            Integer day = Converter.stringToInt(value);
            return new VisitingDay(day);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


    public Orders order() throws IllegalArgumentException{
        try {
            String orderInfos = Console.readLine();
            OrderFormatPattern.matches(orderInfos);
            OrderFormats orderFormats = Converter.stringToOrderFormats(orderInfos);
            return findFoods(orderFormats);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private Orders findFoods(OrderFormats orderFormats) throws IllegalArgumentException{
        Orders orders = new Orders();
        for (int index = 0 ; index < orderFormats.size() ; index++) {
            orders.add(new Order(orderFormats.get(index)));
        }
        return orders;
    }

}
