package christmas;

import camp.nextstep.edu.missionutils.Console;
import menu.MenuBoard;
import order.FoodOrder;
import validator.InputValidator;

import java.util.List;

public class Customer {
    public Integer askVisitingDay() throws IllegalArgumentException{
        String value = Console.readLine();
        return dayValidate(value);
    }

    private Integer dayValidate(String value) throws IllegalArgumentException{
        Integer day = null;
        try {
            InputValidator.checkStringToInt(value);
            day = Integer.parseInt(value);
            checkDayArrange(day);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return day;
    }

    private void checkDayArrange(Integer day) throws IllegalArgumentException{
        if(day < 1 || day > 31)
            throw new IllegalArgumentException();
    }

    public List<FoodOrder> askFoodOrder(MenuBoard menuBoard) throws IllegalArgumentException{
        String foodInfo = Console.readLine();
        return menuBoard.findFoods(foodInfo);
    }


}
