package Event;

import Event.Badge.BadgeEvent;
import Event.DateDiscount.DateDiscountEvent;
import Event.DayDiscount.DayDiscountEvent;
import Event.Gift.GiftEvent;
import Event.Special.SpecialDiscountEvent;
import christmas.Order;
import christmas.Receipt;
import java.util.ArrayList;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class ChristmasEvent {
    List<Event> giftEvent;
    List<Event> disCountEvent;
    List<Event> badgeEvent;

    public ChristmasEvent(){
        setGift();
        setDiscount();
        setBadge();
    }

    private void setGift(){
        giftEvent = new ArrayList<Event>();
        giftEvent.add(new GiftEvent());
    }

    private void setDiscount(){
        disCountEvent = new ArrayList<Event>();
        disCountEvent.add(new DateDiscountEvent());
        disCountEvent.add(new SpecialDiscountEvent());
        disCountEvent.add(new DayDiscountEvent());;
    }

    private void setBadge(){
        badgeEvent = new ArrayList<Event>();
        badgeEvent.add(new BadgeEvent());
    }

    public Receipt applyAllEvent(Order order){
        Receipt receipt = new Receipt();
        applyGift(receipt,order);
        applyDiscount(receipt, order);
        applyBadge(receipt);
        return receipt;
    }

    private void applyGift(Receipt receipt, Order order){
        for (Event event : giftEvent) {
            receipt.addHistory(event.apply(order));
        }
    }

    private void applyDiscount(Receipt receipt, Order order){
        for (Event event : disCountEvent) {
            receipt.addHistory(event.apply(order));
        }
    }

    private void applyBadge(Receipt receipt){
        for (Event event : badgeEvent) {
            receipt.addHistory(event.apply(receipt));
        }
    }

}
