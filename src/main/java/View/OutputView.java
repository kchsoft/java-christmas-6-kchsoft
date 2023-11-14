package View;

import christmas.Menu;
import christmas.Order;

public class OutputView {

    public static void printOrderMenu(Order order) {
        Integer menuCount = 0;
        System.out.println("<주문메뉴>");
        for (Menu oneMenu : order.getMenus()) {
            menuCount = order.countNumberOf(oneMenu);
            printOneMenu(oneMenu,menuCount);
        }
    }

    public static void printOneMenu(Menu menu, Integer menuCount) {
        System.out.println(menu.getName() + " " +menuCount + "개");
    }
}
