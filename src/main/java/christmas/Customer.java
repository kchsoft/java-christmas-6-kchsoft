package christmas;

import menu.Food;
import menu.MenuBoard;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class Customer {
    public int askVisitingDay() {
        Integer day = Integer.valueOf(Console.readLine());
        return day;
    }

    public HashMap<Food,Integer> askOrderInfo(MenuBoard menuBoard) {
        String orderInfo = Console.readLine();
        return menuBoard.findFoods(orderInfo);
    }
}
