package christmas;

import customer.Customer;
import customer.VisitingDay;
import menu.MenuBoard;
import order.FoodOrders;

public class Restaurant {
    MenuBoard menuBoard;

    public Restaurant() {
        this.menuBoard = new MenuBoard();
    }

    public void open(){
        Customer customer = new Customer();
        VisitingDay day = getVisitingDayOf(customer);
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

    private VisitingDay getVisitingDayOf(Customer customer) {
        VisitingDay day = null;
        while (day == null) {
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
