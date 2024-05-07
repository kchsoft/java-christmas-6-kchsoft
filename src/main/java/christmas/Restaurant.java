package christmas;

import Menu.Food;
import Menu.MenuBoard;

import java.util.HashMap;

public class Restaurant {
    MenuBoard menuBoard;

    public Restaurant() {
        this.menuBoard = new MenuBoard();
    }

    public void open(){
        Customer customer = new Customer();
        Integer day = customer.askVisitingDay();
        HashMap<Food,Integer> orderInfo = customer.askOrderInfo(menuBoard);
    }
}
