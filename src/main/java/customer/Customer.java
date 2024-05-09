package customer;

import camp.nextstep.edu.missionutils.Console;
import converter.Converter;
import order.FoodOrder;
import order.FoodOrderFormats;
import order.FoodOrders;

public class Customer {
    public VisitingDay askVisitingDay() throws IllegalArgumentException{
        String value = Console.readLine();
        Integer day = Converter.stringToInt(value);
        return new VisitingDay(day);
    }


    public FoodOrders askFoodOrder() throws IllegalArgumentException{
        try {
            String foodInfos = Console.readLine();
            FoodOrderFormats orderFormats = Converter.stringToFoodOrderFormats(foodInfos);
            return findFood(orderFormats);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private FoodOrders findFood(FoodOrderFormats orderFormats) throws IllegalArgumentException{
        FoodOrders foodOrders = new FoodOrders();
        for (int index = 0 ; index < orderFormats.size() ; index++) {
            foodOrders.add(new FoodOrder(orderFormats.get(index)));
        }
        return foodOrders;
    }

}
