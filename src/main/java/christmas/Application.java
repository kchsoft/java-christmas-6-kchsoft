package christmas;

import Event.Badge.BadgeEvent;
import Event.DateDiscount.DateDiscountEvent;
import Event.DayDiscount.DayDiscountEvent;
import Event.Gift.GiftEvent;
import Event.Special.SpecialDiscountEvent;
import java.time.LocalDate;

public class Application {


    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        LocalDate visitingDay = restaurant.expectVisitngDay();
        Order order = restaurant.orderMenu(visitingDay);
        Receipt receipt = new Receipt(order);

        DateDiscountEvent dateDiscountEvent = new DateDiscountEvent();
        receipt.addHistory(dateDiscountEvent.apply(order));

        SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
        receipt.addHistory(specialDiscountEvent.apply(order));

        DayDiscountEvent dayDiscountEvent = new DayDiscountEvent();
        receipt.addHistory(dayDiscountEvent.apply(order));

        GiftEvent giftEvent = new GiftEvent();
        receipt.addHistory(giftEvent.apply(order));

        BadgeEvent badgeEvent = new BadgeEvent();
        receipt.addHistory(badgeEvent.apply(receipt));
    }

}

