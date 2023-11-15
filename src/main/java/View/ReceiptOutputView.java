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
import christmas.Receipt;
import java.util.List;

public class ReceiptOutputView {

    public static void showReceiptHistory(Receipt receipt){
        printGiftMenu(receipt);
        showBenefitAmount(receipt);
        printFinalPrice(receipt);
        printBadgeHistory(receipt);
    }

    public static void printGiftMenu(Receipt receipt) {
        System.out.println(LINE_BREAKER+"<증정 메뉴>");
        System.out.println(receipt.getGiftName()+BLANK+1+UNIT);
    }

    public static void showBenefitAmount(Receipt receipt){
        showEachBenefit(receipt);
        printSumBenefit(receipt);

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
            System.out.println(oneHistory.explainName() + COLON + BLANK + MINUS + giftPrice.toString());
        }
    }

    public static void printSumBenefit(Receipt receipt){
        System.out.println(LINE_BREAKER + "<총혜택 금액>");
        Money sum = new Money();
        sum.add(receipt.getDiscountAmount());
        sum.add(receipt.getGiftAmount());
        System.out.println(MINUS + sum.toString() + WON);
    }

    public static void printFinalPrice(Receipt receipt) {
        System.out.println(LINE_BREAKER+"<할인 후 예상 결제 금액>");
        Money finalPrice = receipt.findOriginalPrice();
        finalPrice.subtract(receipt.getDiscountAmount());
        System.out.println(finalPrice.toString() + WON);
    }

    public static void printBadgeHistory(Receipt receipt) {
        System.out.println(LINE_BREAKER + "<12월 이벤트 배지>");
        for (EventHistory oneHistory : receipt.getHistory()) {
            if (oneHistory == null || !(oneHistory.getBenefit() instanceof String)) {
                continue;
            }
            System.out.println(oneHistory.getBenefit());
        }
    }

}
