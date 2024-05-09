package customer;

import camp.nextstep.edu.missionutils.Console;
import converter.Converter;
import menu.MenuBoard;
import order.FoodOrders;

public class Customer {
    public VisitingDay askVisitingDay() throws IllegalArgumentException{
        String value = Console.readLine();
        Integer day = Converter.StringToInt(value);
        return new VisitingDay(day);
    }


    public FoodOrders askFoodOrder(MenuBoard menuBoard) throws IllegalArgumentException{
        String foodInfo = Console.readLine();
        return menuBoard.findFoods(foodInfo);
    }


}
