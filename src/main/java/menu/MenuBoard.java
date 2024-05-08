package menu;

import order.FoodOrder;
import validator.InputValidator;

import java.util.LinkedList;
import java.util.List;

public class MenuBoard {

    public List<FoodOrder> findFoods(String foodInfos) throws IllegalArgumentException{
        return foodInfoValidate(foodInfos);
    }

    private List<FoodOrder> foodInfoValidate(String foodInfos) {
        List<FoodOrder> OrderInfos = new LinkedList<>();
        try {
            List<String> eachFoodInfo = splitByComma(foodInfos);
            List<List<String>> eachFoodNameAmount = splitByDash(eachFoodInfo);
            for (List<String> foodNameAmount : eachFoodNameAmount) {
                Food food = Food.findbyName(foodNameAmount.get(0));
                InputValidator.checkStringToInt(foodNameAmount.get(1));
                Integer amount = Integer.parseInt(foodNameAmount.get(1));
                OrderInfos.add(new FoodOrder(food, amount));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return OrderInfos;
    }

    private static List<List<String>> splitByDash(List<String> eachFoodInfo) throws IllegalArgumentException{
        List<String> info;
        List<List<String>> infos = new LinkedList<>();
        for (String foodInfo : eachFoodInfo) {
            String[] nameAmount = foodInfo.split("-");
            if(nameAmount.length < 2) throw new IllegalArgumentException();
            String foodName = nameAmount[0];
            String foodAmount = nameAmount[1];
            info = new LinkedList<>();
            info.add(foodName);
            info.add(foodAmount);
            infos.add(info);
        }
        return infos;
    }

    private List<String> splitByComma(String infos) throws IllegalArgumentException{
        List eachInfo = new LinkedList<>();
        for (String foodInfo : infos.split(",")) {
            eachInfo.add(foodInfo);
        }
        if (eachInfo.size() == 0) {
            throw new IllegalArgumentException();
        }
        return eachInfo;
    }

}
