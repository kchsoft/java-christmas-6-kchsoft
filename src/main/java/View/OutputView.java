package View;

import christmas.Menu;
import christmas.Money;
import christmas.Order;

public class OutputView {

    public static void showOrderHistory(Order order) {
        printOrderMenu(order);
        printOriginalPrice(order);
    }

    public static void printOrderMenu(Order order){
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

    public static void printOriginalPrice(Order order){
        System.out.println("\n할인 전 총주문 금액");
        Money originalPrice = order.sumPrice();
        System.out.println(originalPrice.toString());
    }
}
