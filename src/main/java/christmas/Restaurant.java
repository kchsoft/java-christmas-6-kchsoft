package christmas;

import menu.Food;
import menu.MenuBoard;

import java.util.HashMap;

public class Restaurant {
    MenuBoard menuBoard;

    public Restaurant() {
        this.menuBoard = new MenuBoard();
    }

    public void open(){
        Customer customer = new Customer();
        Integer day = getVisitingDayOf(customer);
        HashMap<Food,Integer> orderInfo = customer.askOrderInfo(menuBoard);
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
