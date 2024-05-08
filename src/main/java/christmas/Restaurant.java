package christmas;

import menu.MenuBoard;
import order.FoodOrders;

public class Restaurant {
    MenuBoard menuBoard;

    public Restaurant() {
        this.menuBoard = new MenuBoard();
    }

    public void open(){
        Customer customer = new Customer();
        Integer day = getVisitingDayOf(customer);
        FoodOrders orderInfo = getFoodOrderOf(customer);
    }

    private FoodOrders getFoodOrderOf(Customer customer) {
        FoodOrders orderInfo = null;
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
