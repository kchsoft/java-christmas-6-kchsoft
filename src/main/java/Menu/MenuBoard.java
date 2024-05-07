package Menu;

import java.util.HashMap;
import java.util.List;

public class MenuBoard {

    public HashMap<Food,Integer> findFoods(List<String> orderInfos) {
        HashMap<Food,Integer> customerOrder = new HashMap<>();
        for (String oneInfo : orderInfos) {
            String[] info = oneInfo.split("-");
            customerOrder.put(Food.valueOf(info[0]), Integer.valueOf(info[1]));
        }
        return customerOrder;
    }

}
