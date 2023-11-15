package View;

import static christmas.Constant.MsgConstantPiece.BLANK;
import static christmas.Constant.MsgConstantPiece.COLON;
import static christmas.Constant.MsgConstantPiece.LINE_BREAKER;
import static christmas.Constant.MsgConstantPiece.MINUS;
import static christmas.Constant.MsgConstantPiece.UNIT;
import static christmas.Constant.MsgConstantPiece.WON;

import Event.EventHistory;
import christmas.Menu;
import christmas.Money;
import christmas.Order;
import christmas.Receipt;
import java.util.List;

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
        System.out.println(menu.getName() + BLANK +menuCount + UNIT);
    }

    public static void printOriginalPrice(Order order){
        System.out.println(LINE_BREAKER+"<할인 전 총주문 금액>");
        Money originalPrice = order.sumPrice();
        System.out.println(originalPrice.toString()+WON);
    }

    public static void showReceiptHistory(Receipt receipt){
        printGiftMenu(receipt);
        showBenefitAmount(receipt);
    }

    public static void printGiftMenu(Receipt receipt) {
        System.out.println(LINE_BREAKER+"<증정 메뉴>");
        System.out.println(receipt.getGiftName()+BLANK+1+UNIT);
    }

    public static void showBenefitAmount(Receipt receipt){
        showEachBenefit(receipt);
//        printSumBenefit();

    }

    public static void showEachBenefit(Receipt receipt){
        System.out.println(LINE_BREAKER+"<혜택 내역>");
        printDiscountBenefit(receipt.getHistory());
        printGiftBenefit(receipt.getHistory());
    }
    public static void printDiscountBenefit(List<EventHistory> history){
        for (EventHistory oneHistory : history) {
            if (oneHistory == null || !(oneHistory.getBenefit() instanceof Money)) {
                continue;
            }
            System.out.println(oneHistory.explainName() + COLON + BLANK + MINUS + oneHistory.explainBenefit()+WON);
        }
    }

    public static void printGiftBenefit(List<EventHistory> history){
        for (EventHistory oneHistory : history) {
            if (oneHistory == null || !(oneHistory.getBenefit() instanceof Menu)) {
                continue;
            }
            Menu giftMenu = ((Menu) oneHistory.getBenefit());
            Money giftPrice = new Money(giftMenu.getPriceValue());
            System.out.println(oneHistory.explainName() + COLON + BLANK + MINUS + giftPrice.toString() );
        }
    }

}
