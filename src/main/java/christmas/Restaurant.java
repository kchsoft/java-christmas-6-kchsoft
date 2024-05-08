package christmas;

import menu.MenuBoard;
import order.FoodOrder;

import java.util.List;

public class Restaurant {
    MenuBoard menuBoard;

    public Restaurant() {
        this.menuBoard = new MenuBoard();
    }

    public void open(){
        Customer customer = new Customer();
        Integer day = getVisitingDayOf(customer);
        List<FoodOrder> orderInfo = getFoodOrderOf(customer);
    }

    private List<FoodOrder> getFoodOrderOf(Customer customer) {
        List<FoodOrder> orderInfo = null;
        while (orderInfo == null) {
            // input view
            try {
                orderInfo = customer.askFoodOrder(menuBoard);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orderInfo;
    }

    private Integer getVisitingDayOf(Customer customer) {
        Integer day = -1;
        while (day == -1) {
            try {
                // input view
                day = customer.askVisitingDay();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return day;
    }
}
