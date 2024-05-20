package view;

import christmas.Badge;
import christmas.Reception;
import eventhistory.EventHistories;
import eventhistory.EventHistory;
import food.Food;
import money.Cost;
import money.UnmodifiedMoney;

import static java.lang.System.out;

public class OutputView {

    public static void showReservationResult(Reception reception) {
        out.println("\n12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        showOrder(reception);
        showTotalCost(reception);
        showGift(reception);
        showBenefitHistory(reception);
        showDiscount(reception);
        showActualPaymentCost(reception);
        showBadge(reception);
    }

    public static void showOrder(Reception reception) {
        out.println("\n<주문 메뉴>");
        for (Food food : reception.getFoods()) {
            Integer amount = reception.getAmount(food);
            out.println(food.getName() + " " + amount + "개");
        }
    }

    public static void showTotalCost(Reception reception) {
        out.println("\n<할인 전 총주문 금액>");
        out.println("" + reception.getTotalCost());
    }

    public static void showGift(Reception reception) {
        out.println("\n<증정 메뉴>");

        if (reception.getGift() == null) {
            out.println("없음");
            return;
        }
        Food gift = reception.getGift();
        out.println(gift.getName() + " " + "1개");
    }

    public static void showBenefitHistory(Reception reception) {
        out.println("\n<혜택 내역>");
        if (!reception.hasEventHistories()) {
            out.println("없음");
            return;
        }
        EventHistories histories = reception.getEventHistories();
        for (Integer index = 0; index < histories.size(); index++) {
            EventHistory history = histories.getHistory(index);
            if(history.getBenefit() instanceof Badge) continue;
            UnmodifiedMoney benefitValue = history.getBenefitValue();
            if(benefitValue.getIntValue() == 0) continue;
            out.println(history.getName() + ": " + "-" + benefitValue);
        }
    }

    public static void showDiscount(Reception reception) {
        out.println("\n<총혜택 금액>");
        if (!reception.hasEventHistories()) {
            out.println("0원");
            return;
        }
        UnmodifiedMoney benefitCost = reception.getBenefitCost();
        out.println("-" + benefitCost);
    }

    public static void showActualPaymentCost(Reception reception) {
        out.println("\n<할인 후 예상 결제 금액>");
        UnmodifiedMoney discount = reception.getDiscount();
        UnmodifiedMoney totalCost = reception.getTotalCost();
        UnmodifiedMoney actualCost = new Cost(totalCost.getIntValue() - discount.getIntValue());
        out.println(actualCost);
    }

    public static void showBadge(Reception reception) {
        out.println("\n<12월 이벤트 배지>");
        Badge badge = reception.getBadge();
        if (badge == null) {
            out.println("없음");
            return;
        }
        out.println(badge.getName());
    }

}