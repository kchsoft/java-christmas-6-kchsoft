package Menu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MenuBoard {

    public HashMap<Food,Integer> findFoods(String orderInfos) {
        HashMap<Food,Integer> customerOrder = new HashMap<>();
        List<String> eachOrderInfos = splitByComma(orderInfos);
        for (String oneOrder : eachOrderInfos) {
            String[] order = oneOrder.split("-");
            customerOrder.put(Food.valueOf(order[0]), Integer.valueOf(order[1]));
        }
        return customerOrder;
    }

    private List<String> splitByComma(String orderInfos) {
        List eachOrderInfos = new LinkedList<>();
        for (String orderInfo : orderInfos.split(",")) {
            eachOrderInfos.add(orderInfo);
        }
        return eachOrderInfos;
    }

}
