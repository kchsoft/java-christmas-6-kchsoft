package View;

import static christmas.Constant.MsgConstantPiece.BLANK;
import static christmas.Constant.MsgConstantPiece.LINE_BREAKER;
import static christmas.Constant.MsgConstantPiece.UNIT;
import static christmas.Constant.MsgConstantPiece.WON;
import static christmas.Constant.OutputMsgConstant.MSG_ORDER_MENU;
import static christmas.Constant.OutputMsgConstant.MSG_ORIGINAL_PRICE;

import christmas.Menu;
import christmas.Money;
import christmas.Order;

public class OrderOutputView {

    public static void showOrderHistory(Order order) {
        printOrderMenu(order);
        printOriginalPrice(order);
    }

    public static void printOrderMenu(Order order){
        Integer menuCount = 0;
        System.out.println(LINE_BREAKER+MSG_ORDER_MENU);
        for (Menu oneMenu : order.getMenus()) {
            menuCount = order.countNumberOf(oneMenu);
            printOneMenu(oneMenu,menuCount);
        }
    }
    public static void printOneMenu(Menu menu, Integer menuCount) {
        System.out.println(menu.getName() + BLANK +menuCount + UNIT);
    }

    public static void printOriginalPrice(Order order){
        System.out.println(LINE_BREAKER+MSG_ORIGINAL_PRICE);
        Money originalPrice = order.sumPrice();
        System.out.println(originalPrice.toString()+WON);
    }

}
